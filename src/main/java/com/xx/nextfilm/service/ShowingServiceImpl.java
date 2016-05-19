package com.xx.nextfilm.service;

import com.xx.nextfilm.dao.*;
import com.xx.nextfilm.dto.ShowingEditor;
import com.xx.nextfilm.entity.*;
import com.xx.nextfilm.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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


    public ShowingEntity findShowingById(Long id, boolean needFcm, boolean needSeats) {
        return showingDao.findById(id, needFcm, needSeats);
    }


    public ShowingEditor getShowingEditorById(Long id, boolean needFcm, boolean needSeats) {
        ShowingEntity showingEntity = findShowingById(id, needFcm, needSeats);

        if (showingEntity == null) return null;

        ShowingEditor showingEditor = new ShowingEditor();

        showingEditor.setId(showingEntity.getId());
        showingEditor.setHallId(showingEntity.getHall().getId());
        showingEditor.setStartTime(Utils.convertDateToString(showingEntity.getStartTime()));
        showingEditor.setEndTime(Utils.convertDateToString(showingEntity.getEndTime()));
        showingEditor.setPriceManual(Utils.convertDoubleToString(showingEntity.getPriceManual()));

        if (needFcm && showingEntity.getFcm() != null) {
            showingEditor.setFilmId(showingEntity.getFcm().getFilm().getId());
        }

        if (needSeats) {
            showingEditor.setSeats(showingEntity.getSeats());
        }

        return showingEditor;
    }


    public boolean createShowing(ShowingEditor showingEditor) {
        HallEntity hall = hallDao.findById(showingEditor.getHallId(), false);

        if (hall == null) return false;

        FilmEntity film = filmDao.findById(showingEditor.getFilmId(), false, false);

        if (film == null) return false;

        CinemaEntity cinema = cinemaDao.findById(showingEditor.getCinemaId(), false, false, false);

        if (cinema == null) return false;

        FCMEntity fcm = fcmDao.findByFilmAndCinema(film, cinema);

        if (fcm == null) return false;

        ShowingEntity showingEntity = getEntityFromEditor(showingEditor, false);
        showingEntity.setHall(hall);
        showingEntity.setFcm(fcm);

        // 添加座位信息
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

        showingDao.doSave(showingEntity);

        return true;
    }


    public boolean updateShowing(ShowingEditor showingEditor) {
        HallEntity hall = hallDao.findById(showingEditor.getHallId(), false);

        if (hall == null) return false;

        FilmEntity film = filmDao.findById(showingEditor.getFilmId(), false, false);

        if (film == null) return false;

        CinemaEntity cinema = cinemaDao.findById(showingEditor.getCinemaId(), false, false, false);

        if (cinema == null) return false;

        FCMEntity fcm = fcmDao.findByFilmAndCinema(film, cinema);

        if (fcm == null) return false;

        ShowingEntity showingEntity = getEntityFromEditor(showingEditor, true);
        showingEntity.setHall(hall);
        showingEntity.setFcm(fcm);

        showingDao.doUpdate(showingEntity);

        return true;
    }


    public void deleteShowing(ShowingEntity showingEntity) {
        showingDao.doDelete(showingEntity);
    }


    private ShowingEntity getEntityFromEditor(ShowingEditor showingEditor, boolean needId) {
        ShowingEntity showingEntity = new ShowingEntity();

        if (needId) {
            showingEntity.setId(showingEditor.getId());
        }

        showingEntity.setStartTime(Utils.convertStringToDate(showingEditor.getStartTime()));
        showingEntity.setEndTime(Utils.convertStringToDate(showingEditor.getEndTime()));
        showingEntity.setPriceManual(Utils.convertStringToDouble(showingEditor.getPriceManual()));

        return showingEntity;
    }

}
