package com.xx.nextfilm.service;

import com.xx.nextfilm.entity.SeatEntity;

/**
 * Created by CuiH on 2016/5/18.
 */
public interface SeatService {

    SeatEntity findSeatById(Long id);

    boolean updateSeatStatusById(Long id, String status);

}
