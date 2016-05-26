package com.xx.nextfilm.dao;

import com.xx.nextfilm.dto.editor.ShowingEditor2;
import com.xx.nextfilm.entity.FCMEntity;
import com.xx.nextfilm.entity.ShowingEntity;
import com.xx.nextfilm.exception.ShowingNotExistException;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

/**
 * Created by CuiH on 2016/5/17.
 */
@Repository("showDao")
public class ShowingDaoImpl extends AbstractDao<Long, ShowingEntity> implements ShowingDao {

    public ShowingEntity findById(Long id, boolean needFcm, boolean needSeats) {
        ShowingEntity showingEntity = getByKey(id);

        if (showingEntity == null) throw new ShowingNotExistException();

        if (needFcm) {
            Hibernate.initialize(showingEntity.getFcm());

            //　同时加载FCM中电影信息
            FCMEntity fcm = showingEntity.getFcm();
            Hibernate.initialize(fcm.getFilm());
        }

        if (needSeats) {
            Hibernate.initialize(showingEntity.getSeats());
        }

        return showingEntity;
    }


    public void doSave(ShowingEntity showing) {
        persist(showing);
    }


    public void doUpdate(ShowingEntity showing) {
        update(showing);
    }


    public boolean doUpdateManually(ShowingEditor2 showing) {
        String hql = "UPDATE showing set "+
                "start_time = :startTime, "+
                "end_time = :endTime, "+
                "price_manual = :priceManual "+
                "WHERE id = :id";
        Query query = createEntityQuery(hql);
        query.setParameter("startTime", showing.getStartTime());
        query.setParameter("endTime", showing.getEndTime());
        query.setParameter("priceManual", showing.getPriceManual());
        query.setParameter("id", showing.getId());
        int l = query.executeUpdate();

        if (l == 0) return false;
        else return true;
    }


    public void doDelete(ShowingEntity showing) {
        delete(showing);
    }

}
