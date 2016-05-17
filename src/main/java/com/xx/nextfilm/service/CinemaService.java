package com.xx.nextfilm.service;

import com.xx.nextfilm.dto.CinemaEditor;
import com.xx.nextfilm.entity.CinemaEntity;

import java.util.List;

/**
 * Created by CuiH on 2016/5/16.
 */
public interface CinemaService {

    CinemaEntity findCinemaById(Long id, boolean needFilms);

    CinemaEditor getCinemaEditorById(Long id, boolean needFilms);

    List<CinemaEntity> findCinemaByName(String name);

    List<CinemaEntity> findCinemaByCityCode(String cityCode);

    void createCinema(CinemaEditor cinemaEditor);

    void updateCinema(CinemaEditor cinemaEditor);

    void deleteCinema(CinemaEntity cinema);

    List<CinemaEntity> findAllCinemas();

}
