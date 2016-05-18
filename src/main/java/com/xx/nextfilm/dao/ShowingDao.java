package com.xx.nextfilm.dao;

import com.xx.nextfilm.entity.ShowingEntity;

/**
 * Created by CuiH on 2016/5/17.
 */
public interface ShowingDao {

    ShowingEntity findById(Long id, boolean needFcm);

    void doSave(ShowingEntity show);

    void doUpdate(ShowingEntity show);

    void doDelete(ShowingEntity show);

}
