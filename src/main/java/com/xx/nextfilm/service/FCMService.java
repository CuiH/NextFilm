package com.xx.nextfilm.service;

import com.xx.nextfilm.entity.CinemaEntity;
import com.xx.nextfilm.entity.FilmEntity;

import java.util.List;

/**
 * Created by CuiH on 2016/5/24.
 */
public interface FCMService {

    void updateFCM(Long cinemaId, List<Long> filmIds);

}
