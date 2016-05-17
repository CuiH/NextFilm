package com.xx.nextfilm.dao;

import com.xx.nextfilm.entity.ShowingEntity;
import org.springframework.stereotype.Repository;

/**
 * Created by CuiH on 2016/5/17.
 */
@Repository("showDao")
public class ShowingDaoImpl extends AbstractDao<Long, ShowingEntity> implements ShowingDao {

    public ShowingEntity findById(Long id) {
        return getByKey(id);
    }


    public void doSave(ShowingEntity show) {
        persist(show);
    }


    public void doUpdate(ShowingEntity show) {
        update(show);
    }


    public void doDelete(ShowingEntity show) {
        delete(show);
    }

}
