package com.xx.nextfilm.service;

import com.xx.nextfilm.dto.editor.ShowingEditor1;
import com.xx.nextfilm.dto.editor.ShowingEditor2;
import com.xx.nextfilm.dto.shower.ShowingShower1;
import com.xx.nextfilm.dto.shower.ShowingShower2;
import com.xx.nextfilm.entity.CinemaEntity;
import com.xx.nextfilm.entity.FCMEntity;
import com.xx.nextfilm.entity.FilmEntity;
import com.xx.nextfilm.entity.ShowingEntity;

import java.util.List;

/**
 * Created by CuiH on 2016/5/17.
 */
public interface ShowingService {

    ShowingEntity findShowingById(Long id, boolean needFcm, boolean needSeats, boolean needCinema);

    List<ShowingShower2> findShowingsByCinemaAndFilmWithShower2(CinemaEntity cinemaEntity, FilmEntity filmEntity);

    ShowingEditor2 getShowingEditor2ById(Long id);


    void createShowing(ShowingEditor1 showingEditor1);

    boolean updateShowing(ShowingEditor2 showingEditor2);

    void deleteShowing(ShowingEntity showingEntity);

}
