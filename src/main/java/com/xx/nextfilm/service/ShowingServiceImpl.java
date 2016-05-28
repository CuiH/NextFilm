package com.xx.nextfilm.service;

import com.xx.nextfilm.controller.MainController;
import com.xx.nextfilm.dao.*;
import com.xx.nextfilm.dto.shower.SeatShower;
import com.xx.nextfilm.dto.editor.ShowingEditor1;
import com.xx.nextfilm.dto.editor.ShowingEditor2;
import com.xx.nextfilm.dto.shower.ShowingShower1;
import com.xx.nextfilm.dto.shower.ShowingShower2;
import com.xx.nextfilm.entity.*;
import com.xx.nextfilm.exception.*;
import com.xx.nextfilm.utils.BuilderUtils;
import com.xx.nextfilm.utils.ConverterUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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

    private static final Logger LOG = LogManager.getLogger("com.xx.nextfilm");

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


    public ShowingEntity findShowingById(Long id, boolean needFcm, boolean needSeats, boolean needCinema)
            throws ShowingNotExistException {
        return showingDao.findById(id, needFcm, needSeats, needCinema);
    }


    public List<ShowingShower2> findShowingsByCinemaAndFilmWithShower2(CinemaEntity cinemaEntity, FilmEntity filmEntity)
            throws FCMNotExistException{
        FCMEntity fcmEntity = fcmDao.findByFilmAndCinema(filmEntity, cinemaEntity);

        return BuilderUtils.getShowingShower2sFromShowingEntities(showingDao.findByFCM(fcmEntity));
    }


    public ShowingEditor2 getShowingEditor2ById(Long id) throws ShowingNotExistException {
        ShowingEntity showingEntity = findShowingById(id, true, true, false);

        ShowingEditor2 showingEditor2 = new ShowingEditor2();

        showingEditor2.setId(showingEntity.getId());
        showingEditor2.setHallName(showingEntity.getHall().getName());
        showingEditor2.setStartTime(ConverterUtils.convertDateTimeToString(showingEntity.getStartTime()));
        showingEditor2.setEndTime(ConverterUtils.convertDateTimeToString(showingEntity.getEndTime()));
        showingEditor2.setPriceManual(ConverterUtils.convertDoubleToString(showingEntity.getPriceManual()));
        showingEditor2.setFilm(BuilderUtils.getFilmShower3FromFilmEntity(showingEntity.getFcm().getFilm()));
        showingEditor2.setSeats(BuilderUtils.getSeatShowersFromSeatEntities(showingEntity.getSeats()));

        return showingEditor2;
    }


    public void createShowing(ShowingEditor1 showingEditor1)
            throws HallNotExistException, FilmNotExistException,
            CinemaNotExistException, FCMNotExistException, UserNotLoginException {
        HallEntity hall = hallDao.findById(showingEditor1.getHallId(), false);
        FilmEntity film = filmDao.findById(showingEditor1.getFilmId(), false, false);
        CinemaEntity cinema = cinemaDao.findById(showingEditor1.getCinemaId(), false, false, false);
        FCMEntity fcm = fcmDao.findByFilmAndCinema(film, cinema);

        ShowingEntity showingEntity = getEntityFromEditor(showingEditor1, false);
        showingEntity.setHall(hall);
        showingEntity.setFcm(fcm);

        showingDao.doSave(showingEntity);

        LOG.info(MainController.getCurrentUsername() + " : add showing - #" + showingEntity.getId());

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
    public boolean updateShowing(ShowingEditor2 showingEditor2) throws UserNotLoginException {
        boolean flag =  showingDao.doUpdateManually(showingEditor2);

        LOG.info(MainController.getCurrentUsername() + " : edit showing - #" + showingEditor2.getId());

        return flag;
    }


    public void deleteShowing(ShowingEntity showingEntity) throws UserNotLoginException {
        showingDao.doDelete(showingEntity);

        LOG.info(MainController.getCurrentUsername() + " : delete showing - #" + showingEntity.getId());
    }


    private ShowingEntity getEntityFromEditor(ShowingEditor1 showingEditor1, boolean needId) {
        ShowingEntity showingEntity = new ShowingEntity();

        if (needId) {
            showingEntity.setId(showingEditor1.getId());
        }

        showingEntity.setStartTime(ConverterUtils.convertStringToDateTime(showingEditor1.getStartTime()));
        showingEntity.setEndTime(ConverterUtils.convertStringToDateTime(showingEditor1.getEndTime()));
        showingEntity.setPriceManual(ConverterUtils.convertStringToDouble(showingEditor1.getPriceManual()));

        return showingEntity;
    }

}
