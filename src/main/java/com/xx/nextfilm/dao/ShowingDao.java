package com.xx.nextfilm.dao;

import com.xx.nextfilm.dto.editor.ShowingEditor2;
import com.xx.nextfilm.entity.FCMEntity;
import com.xx.nextfilm.entity.ShowingEntity;

import java.util.Date;
import java.util.List;

/**
 * Created by CuiH on 2016/5/17.
 */
public interface ShowingDao {

    ShowingEntity findById(Long id, boolean needFcm, boolean needSeats, boolean needCinema);

    List<ShowingEntity> findByFCM(FCMEntity fcmEntity);

    List<ShowingEntity> findByFCMAndDate(FCMEntity fcmEntity, Date date);

    List<ShowingEntity> findSomeByFCMAndDate(FCMEntity fcmEntity, Date date, int num);

    void doSave(ShowingEntity showing);

    void doUpdate(ShowingEntity showing);

    boolean doUpdateManually(ShowingEditor2 showing);

    void doDelete(ShowingEntity showing);

}
