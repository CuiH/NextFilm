package com.xx.nextfilm.dao;

import com.xx.nextfilm.entity.FCMEntity;

/**
 * Created by CuiH on 2016/5/18.
 */
public interface FCMDao {

    FCMEntity findByFilmAndCinema(Long filmId, Long cinemaId);

}
