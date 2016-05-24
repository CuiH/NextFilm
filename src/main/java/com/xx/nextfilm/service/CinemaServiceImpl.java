package com.xx.nextfilm.service;

import com.xx.nextfilm.dao.CinemaDao;
import com.xx.nextfilm.dao.FilmDao;
import com.xx.nextfilm.dao.HallDao;
import com.xx.nextfilm.dto.CinemaEditor;
import com.xx.nextfilm.dto.CinemaShower2;
import com.xx.nextfilm.entity.CinemaEntity;
import com.xx.nextfilm.entity.FCMEntity;
import com.xx.nextfilm.entity.FilmEntity;
import com.xx.nextfilm.entity.HallEntity;
import com.xx.nextfilm.exception.CinemaNotExistException;
import com.xx.nextfilm.utils.ConverterUtils;
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


    // 删掉boolean！
    public CinemaEditor getCinemaEditorById(Long id, boolean needFilms, boolean needHalls, boolean needFcms)
            throws CinemaNotExistException{
        CinemaEntity cinemaEntity = findCinemaById(id, needFilms, needHalls, needFcms);

        CinemaEditor cinemaEditor = new CinemaEditor();

        cinemaEditor.setId(cinemaEntity.getId());
        cinemaEditor.setName(cinemaEntity.getName());
        cinemaEditor.setCity(ConverterUtils.convertCityCodeToCity(cinemaEntity.getCityCode()));
        cinemaEditor.setAddress(cinemaEntity.getAddress());
        cinemaEditor.setPhone(cinemaEntity.getPhone());
        cinemaEditor.setBrief(cinemaEntity.getBrief());
        cinemaEditor.setImageUrl(cinemaEntity.getImageUrl());
        cinemaEditor.setDescription(cinemaEntity.getDescription());

//        List<Long> a = new ArrayList<Long>();
//        List<FilmEntity> films = cinemaEntity.getFilms();
//        if (needFilms && films != null) {
//            for (FilmEntity film: films) {
//                a.add(film.getId());
//            }
//        }
//        cinemaEditor.setFilms(a);

        if (needHalls) {
            List<HallEntity> halls = cinemaEntity.getHalls();
            if (halls == null) cinemaEditor.setHalls(new ArrayList<HallEntity>());
            else cinemaEditor.setHalls(halls);
        }

        if (needFcms) {
            List<FCMEntity> fcms = cinemaEntity.getFcms();
            if (fcms == null) cinemaEditor.setFcms(new ArrayList<FCMEntity>());
            else cinemaEditor.setFcms(fcms);
        }

        return cinemaEditor;
    }


    public List<CinemaEntity> findCinemasByName(String name) {
        return cinemaDao.findByName(name);
    }


    public List<CinemaEntity> findCinemasByCityCode(String cityCode) {
        return cinemaDao.findByCityCode(cityCode);
    }


    public void createCinema(CinemaEditor cinemaEditor) {
        cinemaDao.doSave(getEntityFromEditor(cinemaEditor, false));
    }


    public void updateCinema(CinemaEditor cinemaEditor) {
        cinemaDao.doUpdate(getEntityFromEditor(cinemaEditor, true));
    }


    public void deleteCinema(CinemaEntity cinema) {
        cinemaDao.doDelete(cinema);
    }


    public List<CinemaEntity> findAllCinemas(boolean needFilms, boolean needHalls, boolean needFcms) {
        return cinemaDao.findAll(needFilms, needHalls, needFcms);
    }


    public List<CinemaShower2> findAllCinemasWithShower2() {
        List<CinemaEntity> cinemaEntities = findAllCinemas(false, false, false);

        if (cinemaEntities == null) return new ArrayList<CinemaShower2>();

        List<CinemaShower2> cinemas = new ArrayList<CinemaShower2>();
        for (CinemaEntity cinemaEntity: cinemaEntities) {
            CinemaShower2 cinema = new CinemaShower2();

            cinema.setId(cinemaEntity.getId());
            cinema.setName(cinemaEntity.getName());
            cinema.setAddress(cinemaEntity.getAddress());
            cinema.setImageUrl(cinemaEntity.getImageUrl());

            cinemas.add(cinema);
        }

        return cinemas;
    }

    // 根据ID获取该影院所有上映的电影id List，如果影院不存在返回null
    public List<Long> getAllShowingFilmIdsById(Long id) throws CinemaNotExistException {
        CinemaEntity cinemaEntity = findCinemaById(id, true, false, false);

        List<FilmEntity> films = cinemaEntity.getFilms();

        if (films == null) return new ArrayList<Long>();

        List<Long> ids = new ArrayList<Long>();
        for (FilmEntity filmEntity: films) {
            ids.add(filmEntity.getId());
        }

        return ids;
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

//        List<FilmEntity> films = new ArrayList<FilmEntity>();
//        List<Long> editorFilms = cinemaEditor.getFilms();
//        if (editorFilms != null) {
//            for (Long id: editorFilms) {
//                films.add(filmDao.findById(id, false, false));
//            }
//        }
//        cinemaEntity.setFilms(films);

        return cinemaEntity;
    }

}
