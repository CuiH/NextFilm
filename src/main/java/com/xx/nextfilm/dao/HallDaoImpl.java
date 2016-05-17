package com.xx.nextfilm.dao;

import com.xx.nextfilm.entity.HallEntity;
import org.springframework.stereotype.Repository;

/**
 * Created by CuiH on 2016/5/17.
 */
@Repository("hallDao")
public class HallDaoImpl extends AbstractDao<Long, HallEntity> implements HallDao {

    public HallEntity findById(Long id) {
        return getByKey(id);
    }


    public void doSave(HallEntity hall) {
        persist(hall);
    }


    public void doUpdate(HallEntity hall) {
        update(hall);
    }

    public void doDelete(HallEntity hall) {
        delete(hall);
    }

}
