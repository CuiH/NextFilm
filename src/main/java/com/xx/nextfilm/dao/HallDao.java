package com.xx.nextfilm.dao;

import com.xx.nextfilm.entity.HallEntity;

/**
 * Created by CuiH on 2016/5/17.
 */
public interface HallDao {

    HallEntity findById(Long id);

    void doSave(HallEntity hall);

    void doUpdate(HallEntity hall);

    void doDelete(HallEntity hall);

}
