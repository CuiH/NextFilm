package com.xx.nextfilm.dao;

import com.xx.nextfilm.dto.editor.ShowingEditor2;
import com.xx.nextfilm.entity.FCMEntity;
import com.xx.nextfilm.entity.ShowingEntity;

import java.util.List;

/**
 * Created by CuiH on 2016/5/17.
 */
public interface ShowingDao {

    ShowingEntity findById(Long id, boolean needFcm, boolean needSeats);

    List<ShowingEntity> findByFCM(FCMEntity fcmEntity);

    void doSave(ShowingEntity showing);

    void doUpdate(ShowingEntity showing);

    boolean doUpdateManually(ShowingEditor2 showing);

    void doDelete(ShowingEntity showing);

}
