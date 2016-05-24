package com.xx.nextfilm.service;

import com.xx.nextfilm.dao.*;
import com.xx.nextfilm.dto.SeatShower;
import com.xx.nextfilm.dto.ShowingEditor1;
import com.xx.nextfilm.dto.ShowingEditor2;
import com.xx.nextfilm.entity.*;
import com.xx.nextfilm.exception.*;
import com.xx.nextfilm.utils.BuilderUtils;
import com.xx.nextfilm.utils.ConverterUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by CuiH on 2016/5/17.
 */
@Transactional
@Service("showService")
public class ShowingServiceImpl implements ShowingService {

    @Autowired
    ShowingDao showingDao;

    @Autowired
    HallDao hallDao;

    @Autowired
    CinemaDao cinemaDao;

    @Autowired
    FCMDao fcmDao;

    @Autowired
    FilmDao filmDao;

    @Autowired
    SeatDao seatDao;


    public ShowingEntity findShowingById(Long id, boolean needFcm, boolean needSeats)
            throws ShowingNotExistException {
        return showingDao.findById(id, needFcm, needSeats);
    }


    public ShowingEditor2 getShowingEditor2ById(Long id) throws ShowingNotExistException {
        ShowingEntity showingEntity = findShowingById(id, true, true);

        ShowingEditor2 showingEditor2 = new ShowingEditor2();

        showingEditor2.setId(showingEntity.getId());
        showingEditor2.setHallName(showingEntity.getHall().getName());
        showingEditor2.setStartTime(ConverterUtils.convertDateToString(showingEntity.getStartTime()));
        showingEditor2.setEndTime(ConverterUtils.convertDateToString(showingEntity.getEndTime()));
        showingEditor2.setPriceManual(ConverterUtils.convertDoubleToString(showingEntity.getPriceManual()));
        showingEditor2.setFilmName(showingEntity.getFcm().getFilm().getName());

        List<SeatShower> seats = new ArrayList<SeatShower>();
        List<SeatEntity> seatEntities = showingEntity.getSeats();
        if (seatEntities != null) {
            for (SeatEntity seat: seatEntities) {
                seats.add(BuilderUtils.getSeatShower1FromSeatEntity(seat));
            }
        }
        showingEditor2.setSeats(seats);

        return showingEditor2;
    }


    public void createShowing(ShowingEditor1 showingEditor1)
            throws HallNotExistException, FilmNotExistException, CinemaNotExistException, FCMNotExistException {
        HallEntity hall = hallDao.findById(showingEditor1.getHallId(), false);
        FilmEntity film = filmDao.findById(showingEditor1.getFilmId(), false, false);
        CinemaEntity cinema = cinemaDao.findById(showingEditor1.getCinemaId(), false, false, false);
        FCMEntity fcm = fcmDao.findByFilmAndCinema(film, cinema);

        ShowingEntity showingEntity = getEntityFromEditor(showingEditor1, false);
        showingEntity.setHall(hall);
        showingEntity.setFcm(fcm);

        showingDao.doSave(showingEntity);

        // 根据hall大小添加座位
        Short rowNum = hall.getRowNum();
        Short columnNum = hall.getColumnNum();
        for (Short row = 1; row <= rowNum; row++) {
            for (Short column = 1; column <= columnNum; column++) {
                SeatEntity seat = new SeatEntity();
                seat.setRowPos(row);
                seat.setColumnPos(column);
                seat.setShowing(showingEntity);
                seat.setStatus("1");
                seatDao.doSave(seat);
            }
        }
    }


    // 只可改变showing信息，不可改变所属hall、关联的影片
    public boolean updateShowing(ShowingEditor2 showingEditor2) {
        return showingDao.doUpdateManually(showingEditor2);
    }


    public void deleteShowing(ShowingEntity showingEntity) {
        showingDao.doDelete(showingEntity);
    }


    private ShowingEntity getEntityFromEditor(ShowingEditor1 showingEditor1, boolean needId) {
        ShowingEntity showingEntity = new ShowingEntity();

        if (needId) {
            showingEntity.setId(showingEditor1.getId());
        }

        showingEntity.setStartTime(ConverterUtils.convertStringToDate(showingEditor1.getStartTime()));
        showingEntity.setEndTime(ConverterUtils.convertStringToDate(showingEditor1.getEndTime()));
        showingEntity.setPriceManual(ConverterUtils.convertStringToDouble(showingEditor1.getPriceManual()));

        return showingEntity;
    }

}
