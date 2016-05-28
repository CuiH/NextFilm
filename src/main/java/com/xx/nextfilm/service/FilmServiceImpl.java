package com.xx.nextfilm.service;

import com.xx.nextfilm.controller.back.MainController;
import com.xx.nextfilm.dao.ActorDao;
import com.xx.nextfilm.dao.FilmDao;
import com.xx.nextfilm.dto.editor.FilmEditor;
import com.xx.nextfilm.dto.shower.FilmShower1;
import com.xx.nextfilm.dto.shower.FilmShower2;
import com.xx.nextfilm.dto.shower.FilmShower3;
import com.xx.nextfilm.entity.ActorEntity;
import com.xx.nextfilm.entity.FilmEntity;
import com.xx.nextfilm.exception.ActorNotExistException;
import com.xx.nextfilm.exception.FilmNotExistException;
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
 * Created by CuiH on 2016/5/15.
 */
@Transactional
@Service("filmService")
public class FilmServiceImpl implements FilmService {

    private static final Logger LOG = LogManager.getLogger("com.xx.nextfilm");

    @Autowired
    FilmDao filmDao;

    @Autowired
    ActorDao actorDao;


    public FilmEntity findFilmById(Long id, boolean needDirectors, boolean needActors)
            throws FilmNotExistException {
        return filmDao.findById(id, needDirectors, needActors);
    }


    public FilmEditor getFilmEditorById(Long id) throws FilmNotExistException {
        FilmEntity filmEntity = findFilmById(id, true, true);

        FilmEditor filmEditor = new FilmEditor();

        filmEditor.setId(filmEntity.getId());
        filmEditor.setName(filmEntity.getName());
        filmEditor.setAlias(filmEntity.getAlias());
        filmEditor.setBrief(filmEntity.getBrief());
        filmEditor.setLanguage(filmEntity.getLanguage());
        filmEditor.setLength(filmEntity.getLength());
        filmEditor.setOnDate(ConverterUtils.convertDateToString(filmEntity.getOnDate()));
        filmEditor.setImageUrl(filmEntity.getImageUrl());
        filmEditor.setCategory(filmEntity.getCategory());
        filmEditor.setType(filmEntity.getType());

        filmEditor.setOwnedActors(BuilderUtils.getActorShower2sFromActorEntities(filmEntity.getActors()));
        filmEditor.setOwnedDirectors(BuilderUtils.getActorShower2sFromActorEntities(filmEntity.getDirectors()));

        return filmEditor;
    }


    public List<FilmEntity> findFilmsByName(String name) {
        List<FilmEntity> list1 = filmDao.findByName(name);
        List<FilmEntity> list2 = filmDao.findByAlias(name);

        for (FilmEntity film: list2) {
            boolean flag = false;
            for (FilmEntity f: list1) {
                if (film.getId() == f.getId()) {
                    flag = true;
                    break;
                }
            }

            if (flag == false) {
                list1.add(film);
            }
        }

        return list1;
    }


    public List<FilmEntity> findFilmsByType(String type) {
        return filmDao.findByType(type);
    }


    public List<FilmEntity> findFilmsByCategory(String category) {
        return filmDao.findByCategory(category);
    }


    public void createFilm(FilmEditor filmEditor) throws ActorNotExistException, UserNotLoginException {
        FilmEntity filmEntity = getEntityFromEditor(filmEditor, false);
        filmDao.doSave(filmEntity);

        LOG.info(MainController.getCurrentUsername() + " : add film - #" + filmEntity.getId());
    }


    public void updateFilm(FilmEditor filmEditor) throws ActorNotExistException, UserNotLoginException {
        filmDao.doUpdate(getEntityFromEditor(filmEditor, true));

        LOG.info(MainController.getCurrentUsername() + " : edit film - #" + filmEditor.getId());
    }


    public void deleteFilm(FilmEntity film) throws UserNotLoginException {
        filmDao.doDelete(film);

        LOG.info(MainController.getCurrentUsername() + " : delete film - #" + film.getId());
    }


    public List<FilmEntity> findAllFilms(boolean needDirectors, boolean needActors) {
        return filmDao.findAll(needDirectors, needActors);
    }


    public List<FilmShower1> findAllFilmsWithShower1() {
        List<FilmEntity> filmEntities = findAllFilms(true, true);

        List<FilmShower1> films = new ArrayList<FilmShower1>();
        for (FilmEntity filmEntity: filmEntities) {
            FilmShower1 film = new FilmShower1();

            film.setDirectors(BuilderUtils.getActorShower2sFromActorEntities(filmEntity.getDirectors()));
            film.setActors(BuilderUtils.getActorShower2sFromActorEntities(filmEntity.getActors()));

            film.setId(filmEntity.getId());
            film.setName(filmEntity.getName());
            film.setAlias(filmEntity.getAlias());
            film.setBrief(filmEntity.getBrief());
            film.setLanguage(filmEntity.getLanguage());
            film.setLength(filmEntity.getLength());
            film.setOnDate(ConverterUtils.convertDateToString(filmEntity.getOnDate()));
            film.setImageUrl(filmEntity.getImageUrl());
            film.setCategory(filmEntity.getCategory());
            film.setType(filmEntity.getType());

            films.add(film);
        }

        return films;
    }

    public List<FilmShower2> findAllFilmsWithShower2() {
        List<FilmEntity> filmEntities = findAllFilms(false, false);

        List<FilmShower2> films = new ArrayList<FilmShower2>();
        for (FilmEntity filmEntity: filmEntities) {
            FilmShower2 film = new FilmShower2();

            film.setId(filmEntity.getId());
            film.setName(filmEntity.getName());
            film.setBrief(filmEntity.getBrief());
            film.setLanguage(filmEntity.getLanguage());
            film.setImageUrl(filmEntity.getImageUrl());

            films.add(film);
        }

        return films;
    }


    public List<FilmShower3> findAllFilmsWithShower3() {
        List<FilmEntity> filmEntities = findAllFilms(false, false);

        List<FilmShower3> films = new ArrayList<FilmShower3>();
        for (FilmEntity filmEntity: filmEntities) {
            FilmShower3 film = new FilmShower3();

            film.setId(filmEntity.getId());
            film.setName(filmEntity.getName());

            films.add(film);
        }

        return films;
    }


    private FilmEntity getEntityFromEditor(FilmEditor filmEditor, boolean needId)
            throws ActorNotExistException {
        FilmEntity filmEntity = new FilmEntity();

        if (needId) {
            filmEntity.setId(filmEditor.getId());
        }

        filmEntity.setName(filmEditor.getName());
        filmEntity.setAlias(filmEditor.getAlias());
        filmEntity.setBrief(filmEditor.getBrief());
        filmEntity.setLanguage(filmEditor.getLanguage());
        filmEntity.setLength(filmEditor.getLength());
        filmEntity.setOnDate(ConverterUtils.convertStringToDate(filmEditor.getOnDate()));
        filmEntity.setImageUrl(filmEditor.getImageUrl());
        filmEntity.setCategory(filmEditor.getCategory());
        filmEntity.setType(filmEditor.getType());

        List<ActorEntity> directors = new ArrayList<ActorEntity>();
        List<Long> editorDirectors = filmEditor.getDirectors();
        if (editorDirectors != null) {
            for (Long id: editorDirectors) {
                directors.add(actorDao.findById(id));
            }
        }
        filmEntity.setDirectors(directors);

        List<ActorEntity> actors = new ArrayList<ActorEntity>();
        List<Long> editorActors = filmEditor.getActors();
        if (editorActors != null) {
            for (Long id: editorActors) {
                actors.add(actorDao.findById(id));
            }
        }
        filmEntity.setActors(actors);

        return filmEntity;
    }

}
