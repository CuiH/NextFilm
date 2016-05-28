package com.xx.nextfilm.service;

import com.xx.nextfilm.dto.editor.ReservationEditor;
import com.xx.nextfilm.entity.PurchaseOrderEntity;
import com.xx.nextfilm.entity.UserEntity;

import java.util.List;

/**
 * Created by cuihao on 2016/5/27.
 */
public interface ReservationService {

    void makeReservation(UserEntity user, ReservationEditor reservation);

    List<PurchaseOrderEntity> findReservationsByUser(UserEntity user);

}
