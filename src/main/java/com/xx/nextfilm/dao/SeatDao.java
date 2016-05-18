package com.xx.nextfilm.dao;

import com.xx.nextfilm.entity.SeatEntity;

/**
 * Created by CuiH on 2016/5/18.
 */
public interface SeatDao {

    SeatEntity findById(Long id);

    SeatEntity findBySerialNum(String serialNum);

    void doSave(SeatEntity seat);

    void updateStatusById(Long id, String status);

}
