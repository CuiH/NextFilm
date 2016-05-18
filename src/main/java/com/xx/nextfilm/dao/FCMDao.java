package com.xx.nextfilm.dao;

import com.xx.nextfilm.entity.CinemaEntity;
import com.xx.nextfilm.entity.FCMEntity;
import com.xx.nextfilm.entity.FilmEntity;

/**
 * Created by CuiH on 2016/5/18.
 */
public interface FCMDao {

    FCMEntity findByFilmAndCinema(FilmEntity film, CinemaEntity cinema);

}
