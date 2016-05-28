package com.xx.nextfilm.dao;

import com.xx.nextfilm.entity.PurchaseOrderEntity;
import com.xx.nextfilm.entity.UserEntity;

import java.util.List;

/**
 * Created by cuihao on 2016/5/27.
 */
public interface PurchaseOrderDao {

    PurchaseOrderEntity findById(Long id);

    List<PurchaseOrderEntity> findByUser(UserEntity user);

    void doSave(PurchaseOrderEntity purchaseOrder);

}
