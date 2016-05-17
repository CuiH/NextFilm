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


    public ShowingEntity findShowById(Long id) {
        return showingDao.findById(id);
    }


    public ShowingEntity getShowEditorById(Long id) {
        ShowingEntity showingEntity = findShowById(id);

        if (showingEntity == null) return null;

        ShowingEditor showingEditor = new ShowingEditor();

        showingEditor.setId(showingEntity.getId());
        showingEditor.setStartTime(Utils.convertDateToString(showingEntity.getStartTime()));
        showingEditor.setEndTime(Utils.convertDateToString(showingEntity.getEndTime()));
        showingEditor.setPriceManual(Utils.convertDoubleToString(showingEntity.getPriceManual()));

        return showingEntity;
    }


    public boolean createShow(ShowingEditor showingEditor) {
        HallEntity hall = hallDao.findById(showingEditor.getHallId());

        if (hall == null) return false;

        FilmEntity film = filmDao.findById(showingEditor.getFilmId(), false, false);

        if (film == null) return false;

        CinemaEntity cinema = cinemaDao.findById(showingEditor.getCinemaId(), false, false, false);

        if (cinema == null) return false;

        FCMEntity fcm = fcmDao.findByFilmAndCinema(film.getId(), cinema.getId());

        if (fcm == null) return false;

        ShowingEntity showingEntity = getEntityFromEditor(showingEditor, false);
        showingEntity.setHall(hall);
        showingEntity.setFcm(fcm);

        showingDao.doSave(showingEntity);

        return true;
    }


    public boolean updateShow(ShowingEditor showingEditor) {
        return false;
    }


    public void deleteShow(ShowingEntity showingEntity) {
        showingDao.doDelete(showingEntity);
    }


    private ShowingEntity getEntityFromEditor(ShowingEditor showingEditor, boolean needId) {
        ShowingEntity showingEntity = new ShowingEntity();

        if (needId) {
            showingEditor.setId(showingEditor.getId());
        }

        showingEntity.setStartTime(Utils.convertStringToDate(showingEditor.getStartTime()));
        showingEntity.setEndTime(Utils.convertStringToDate(showingEditor.getEndTime()));
        showingEntity.setPriceManual(Utils.convertStringToDouble(showingEditor.getPriceManual()));

        return showingEntity;
    }

}
