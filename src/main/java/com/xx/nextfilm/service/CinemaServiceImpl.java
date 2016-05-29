package com.xx.nextfilm.service;

import com.xx.nextfilm.controller.back.MainController;
import com.xx.nextfilm.dao.CinemaDao;
import com.xx.nextfilm.dao.FilmDao;
import com.xx.nextfilm.dao.HallDao;
import com.xx.nextfilm.dto.editor.CinemaEditor;
import com.xx.nextfilm.dto.shower.CinemaShower2;
import com.xx.nextfilm.entity.CinemaEntity;
import com.xx.nextfilm.entity.FilmEntity;
import com.xx.nextfilm.exception.CinemaNotExistException;
import com.xx.nextfilm.exception.UserNotLoginException;
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
 * Created by CuiH on 2016/5/16.
 */
@Transactional
@Service("cinemaService")
public class CinemaServiceImpl implements CinemaService {

    private static final Logger LOG = LogManager.getLogger("com.xx.nextfilm");

    @Autowired
    CinemaDao cinemaDao;

    @Autowired
    HallDao hallDao;

    @Autowired
    FilmDao filmDao;


    public CinemaEntity findCinemaById(Long id, boolean needFilms, boolean needHalls, boolean needFcms)
            throws CinemaNotExistException {
        return cinemaDao.findById(id, needFilms, needHalls, needFcms);
    }


    public CinemaEditor getCinemaEditorById(Long id)
            throws CinemaNotExistException{
        CinemaEntity cinemaEntity = findCinemaById(id, true, true, false);

        CinemaEditor cinemaEditor = new CinemaEditor();

        cinemaEditor.setId(cinemaEntity.getId());
        cinemaEditor.setName(cinemaEntity.getName());
        cinemaEditor.setCity(ConverterUtils.convertCityCodeToCity(cinemaEntity.getCityCode()));
        cinemaEditor.setAddress(cinemaEntity.getAddress());
        cinemaEditor.setPhone(cinemaEntity.getPhone());
        cinemaEditor.setBrief(cinemaEntity.getBrief());
        cinemaEditor.setImageUrl(cinemaEntity.getImageUrl());
        cinemaEditor.setDescription(cinemaEntity.getDescription());

        cinemaEditor.setHalls(BuilderUtils.getHallShower1sFromHallEntities(cinemaEntity.getHalls()));
        cinemaEditor.setFilms(BuilderUtils.getFilmShower2sFromFilmEntities(cinemaEntity.getFilms()));

        return cinemaEditor;
    }


    public List<CinemaEntity> findSomeCinemas(int num, boolean needFilms, boolean needHalls, boolean needFcms) {
        return cinemaDao.findSome(num, needFilms, needHalls, needFcms);
    }


    public List<CinemaEntity> findCinemasByName(String name, boolean needFilms, boolean needHalls, boolean needFcms) {
        return cinemaDao.findByName(name, needFilms, needHalls, needFcms);
    }


    public List<CinemaEntity> findCinemasByCityCode(String cityCode) {
        return cinemaDao.findByCityCode(cityCode);
    }


    public void createCinema(CinemaEditor cinemaEditor) throws UserNotLoginException {
        CinemaEntity cinemaEntity = getEntityFromEditor(cinemaEditor, false);
        cinemaDao.doSave(cinemaEntity);

        LOG.info(MainController.getCurrentUsername() + " : add cinema - #" + cinemaEntity.getId());
    }


    // 只可改变cinema信息，不可改变其上映电影等
    public boolean updateCinema(CinemaEditor cinemaEditor) throws UserNotLoginException {
        boolean flag = cinemaDao.doUpdateManually(getEntityFromEditor(cinemaEditor, true));

        LOG.info(MainController.getCurrentUsername() + " : edit cinema - #" + cinemaEditor.getId());

        return flag;
    }


    public void deleteCinema(CinemaEntity cinema) throws UserNotLoginException {
        cinemaDao.doDelete(cinema);

        LOG.info(MainController.getCurrentUsername() + " : delete cinema - #" + cinema.getId());
    }


    public List<CinemaEntity> findAllCinemas(boolean needFilms, boolean needHalls, boolean needFcms) {
        return cinemaDao.findAll(needFilms, needHalls, needFcms);
    }


    public List<CinemaShower2> findAllCinemasWithShower2() {
        List<CinemaEntity> cinemaEntities = findAllCinemas(false, false, false);

        return BuilderUtils.getCinemaShower2sFromCinemaEntities(cinemaEntities);
    }


    private CinemaEntity getEntityFromEditor(CinemaEditor cinemaEditor, boolean needId) {
        CinemaEntity cinemaEntity = new CinemaEntity();

        if (needId) {
            cinemaEntity.setId(cinemaEditor.getId());
        }

        cinemaEntity.setName(cinemaEditor.getName());
        cinemaEntity.setCityCode(ConverterUtils.convertCityToCityCode(cinemaEditor.getCity()));
        cinemaEntity.setAddress(cinemaEditor.getAddress());
        cinemaEntity.setPhone(cinemaEditor.getPhone());
        cinemaEntity.setBrief(cinemaEditor.getBrief());
        cinemaEntity.setImageUrl(cinemaEditor.getImageUrl());
        cinemaEntity.setDescription(cinemaEditor.getDescription());

        return cinemaEntity;
    }

}
