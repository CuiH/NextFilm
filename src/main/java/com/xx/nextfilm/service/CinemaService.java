package com.xx.nextfilm.service;

import com.xx.nextfilm.dto.editor.CinemaEditor;
import com.xx.nextfilm.dto.shower.CinemaShower2;
import com.xx.nextfilm.entity.CinemaEntity;

import java.util.List;

/**
 * Created by CuiH on 2016/5/16.
 */
public interface CinemaService {

    CinemaEntity findCinemaById(Long id, boolean needFilms, boolean needHalls, boolean needFcms);

    CinemaEditor getCinemaEditorById(Long id);

    List<CinemaEntity> findCinemasByName(String name, boolean needFilms, boolean needHalls, boolean needFcms);

    List<CinemaEntity> findSomeCinemas(int num, boolean needFilms, boolean needHalls, boolean needFcms);

    List<CinemaEntity> findCinemasByCityCode(String cityCode);

    void createCinema(CinemaEditor cinemaEditor);

    boolean updateCinema(CinemaEditor cinemaEditor);

    void deleteCinema(CinemaEntity cinema);

    List<CinemaShower2> findAllCinemasWithShower2();

    List<CinemaEntity> findAllCinemas(boolean needFilms, boolean needHalls, boolean needFcms);

}
