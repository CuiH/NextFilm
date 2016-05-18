package com.xx.nextfilm.dao;

import com.xx.nextfilm.entity.FCMEntity;
import com.xx.nextfilm.entity.ShowingEntity;
import org.hibernate.Hibernate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by CuiH on 2016/5/17.
 */
@Repository("showDao")
public class ShowingDaoImpl extends AbstractDao<Long, ShowingEntity> implements ShowingDao {

    public ShowingEntity findById(Long id, boolean needFcm, boolean needSeats) {
        ShowingEntity showingEntity = getByKey(id);

        if (needFcm && showingEntity != null) {
            Hibernate.initialize(showingEntity.getFcm());

            //　同时加载FCM中电影信息
            FCMEntity fcm = showingEntity.getFcm();
            Hibernate.initialize(fcm.getFilm());
        }

        if (needSeats && showingEntity != null) {
            Hibernate.initialize(showingEntity.getSeats());
        }

        return showingEntity;
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
