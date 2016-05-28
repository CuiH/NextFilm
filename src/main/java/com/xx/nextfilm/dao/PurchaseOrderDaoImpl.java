package com.xx.nextfilm.dao;

import com.xx.nextfilm.entity.ActorEntity;
import com.xx.nextfilm.entity.PurchaseOrderEntity;
import com.xx.nextfilm.entity.UserEntity;
import com.xx.nextfilm.exception.PurchaseOrderNotExistException;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cuihao on 2016/5/27.
 */
@Repository("purchaseOrderDao")
public class PurchaseOrderDaoImpl extends AbstractDao<Long, PurchaseOrderEntity>
        implements PurchaseOrderDao {

    public PurchaseOrderEntity findById(Long id) {
        PurchaseOrderEntity purchaseOrderEntity = getByKey(id);

        if (purchaseOrderEntity == null) throw new PurchaseOrderNotExistException();

        return purchaseOrderEntity;
    }


    public List<PurchaseOrderEntity> findByUserId(Long userId) {
        return null;
    }


    public void doSave(PurchaseOrderEntity purchaseOrder) {
        persist(purchaseOrder);
    }


    public List<PurchaseOrderEntity> findByUser(UserEntity user) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("user", user));
        // 否则会duplicate
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        List<PurchaseOrderEntity> purchaseOrders = (List<PurchaseOrderEntity>) criteria.list();

        if (purchaseOrders == null) return new ArrayList<PurchaseOrderEntity>();

        return purchaseOrders;
    }

}
