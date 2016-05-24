package com.xx.nextfilm.service;

import com.xx.nextfilm.dto.FilmEditor;
import com.xx.nextfilm.dto.FilmShower1;
import com.xx.nextfilm.dto.FilmShower3;
import com.xx.nextfilm.entity.FilmEntity;

import java.util.HashMap;
import java.util.List;

/**
 * Created by CuiH on 2016/5/15.
 */
public interface FilmService {

    FilmEntity findFilmById(Long id, boolean needDirectors, boolean needActors);

    FilmEditor getFilmEditorById(Long id);

    List<FilmEntity> findFilmByName(String name);

    List<FilmEntity> findFilmByType(String type);

    List<FilmEntity> findFilmByCategory(String category);

    void createFilm(FilmEditor filmEditor);

    void updateFilm(FilmEditor filmEditor);

    void deleteFilm(FilmEntity film);

    List<FilmEntity> findAllFilms(boolean needDirectors, boolean needActors);

    List<FilmShower1> findAllFilmsWithShower1();

    List<FilmShower3> findAllFilmsWithShower3();

}
