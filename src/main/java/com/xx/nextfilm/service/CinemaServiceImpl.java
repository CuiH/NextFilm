package com.xx.nextfilm.service;

import com.xx.nextfilm.dao.CinemaDao;
import com.xx.nextfilm.dao.FilmDao;
import com.xx.nextfilm.dto.CinemaEditor;
import com.xx.nextfilm.entity.CinemaEntity;
import com.xx.nextfilm.entity.FilmEntity;
import com.xx.nextfilm.entity.HallEntity;
import com.xx.nextfilm.utils.Utils;
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
    FilmDao filmDao;


    public CinemaEntity findCinemaById(Long id, boolean needFilms, boolean needHalls) {
        return cinemaDao.findById(id, needFilms, needHalls);
    }


    public CinemaEditor getCinemaEditorById(Long id, boolean needFilms, boolean needHalls) {
        CinemaEntity cinemaEntity = findCinemaById(id, needFilms, needHalls);

        if (cinemaEntity == null) return null;

        CinemaEditor cinemaEditor = new CinemaEditor();

        cinemaEditor.setId(cinemaEntity.getId());
        cinemaEditor.setName(cinemaEntity.getName());
        cinemaEditor.setCity(Utils.convertCityCodeToCity(cinemaEntity.getCityCode()));
        cinemaEditor.setAddress(cinemaEntity.getAddress());
        cinemaEditor.setPhone(cinemaEntity.getPhone());
        cinemaEditor.setBrief(cinemaEntity.getBrief());
        cinemaEditor.setImageUrl(cinemaEntity.getImageUrl());
        cinemaEditor.setDescription(cinemaEntity.getDescription());

        List<Long> a = new ArrayList<Long>();
        List<FilmEntity> films = cinemaEntity.getFilms();
        if (needFilms && films != null) {
            for (FilmEntity film: films) {
                a.add(film.getId());
            }
        }
        cinemaEditor.setFilms(a);

        if (needHalls) {
            List<HallEntity> halls = cinemaEntity.getHalls();
            if (halls == null) cinemaEditor.setHalls(new ArrayList<HallEntity>());
            else cinemaEditor.setHalls(halls);
        }

        return cinemaEditor;
    }


    public List<CinemaEntity> findCinemaByName(String name) {
        return cinemaDao.findByName(name);
    }


    public List<CinemaEntity> findCinemaByCityCode(String cityCode) {
        return cinemaDao.findByCityCode(cityCode);
    }


    public void createCinema(CinemaEditor cinemaEditor) {
        cinemaDao.doSave(getEntityFromEditor(cinemaEditor, false));
    }


    public void updateCinema(CinemaEditor cinemaEditor) {
        cinemaDao.doUpdate(getEntityFromEditor(cinemaEditor, true));
    }


    private CinemaEntity getEntityFromEditor(CinemaEditor cinemaEditor, boolean needId) {
        CinemaEntity cinemaEntity = new CinemaEntity();

        if (needId) {
            cinemaEntity.setId(cinemaEditor.getId());
        }

        cinemaEntity.setName(cinemaEditor.getName());
        cinemaEntity.setCityCode(Utils.convertCityToCityCode(cinemaEditor.getCity()));
        cinemaEntity.setAddress(cinemaEditor.getAddress());
        cinemaEntity.setPhone(cinemaEditor.getPhone());
        cinemaEntity.setBrief(cinemaEditor.getBrief());
        cinemaEntity.setImageUrl(cinemaEditor.getImageUrl());
        cinemaEntity.setDescription(cinemaEditor.getDescription());

        List<FilmEntity> films = new ArrayList<FilmEntity>();
        List<Long> editorFilms = cinemaEditor.getFilms();
        if (editorFilms != null) {
            for (Long id: editorFilms) {
                films.add(filmDao.findById(id, false, false));
            }
        }
        cinemaEntity.setFilms(films);

        return cinemaEntity;
    }


    public void deleteCinema(CinemaEntity cinema) {
        cinemaDao.doDelete(cinema);
    }


    public List<CinemaEntity> findAllCinemas(boolean needFilms, boolean needHalls) {
        return cinemaDao.findAll(needFilms, needHalls);
    }

}
