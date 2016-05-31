package com.xx.nextfilm.dao;

import com.xx.nextfilm.entity.PurchaseOrderEntity;
import com.xx.nextfilm.entity.UserEntity;

import java.util.List;

/**
 * Created by cuihao on 2016/5/27.
 */
public interface PurchaseOrderDao {

    PurchaseOrderEntity findById(Long id, boolean needOrderItems);

    List<PurchaseOrderEntity> findByUser(UserEntity user, boolean needOrderItems);

    void doSave(PurchaseOrderEntity purchaseOrder);

    void doDelete(PurchaseOrderEntity purchaseOrder);

}
