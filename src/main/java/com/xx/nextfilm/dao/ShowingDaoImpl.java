package com.xx.nextfilm.dao;

import com.xx.nextfilm.dto.editor.ShowingEditor2;
import com.xx.nextfilm.entity.FCMEntity;
import com.xx.nextfilm.entity.FilmEntity;
import com.xx.nextfilm.entity.ShowingEntity;
import com.xx.nextfilm.exception.ShowingNotExistException;
import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by CuiH on 2016/5/17.
 */
@Repository("showDao")
public class ShowingDaoImpl extends AbstractDao<Long, ShowingEntity> implements ShowingDao {

    public ShowingEntity findById(Long id, boolean needFcm, boolean needSeats, boolean needCinema) {
        ShowingEntity showingEntity = getByKey(id);

        if (showingEntity == null) throw new ShowingNotExistException();

        if (needFcm) {
            Hibernate.initialize(showingEntity.getFcm());

            //　同时加载FCM中电影信息
            FCMEntity fcm = showingEntity.getFcm();
            Hibernate.initialize(fcm.getFilm());

            if (needCinema) {
                Hibernate.initialize(fcm.getCinema());
            }
        }

        if (needSeats) {
            Hibernate.initialize(showingEntity.getSeats());
        }

        return showingEntity;
    }


    public List<ShowingEntity> findByFCM(FCMEntity fcmEntity) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("fcm", fcmEntity));
        List<ShowingEntity> showings = (List<ShowingEntity>) criteria.list();

        if (showings == null) return new ArrayList<ShowingEntity>();

        return showings;
    }


    public List<ShowingEntity> findByFCMAndDate(FCMEntity fcmEntity, Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(calendar.DATE, 1);
        Date next = calendar.getTime();

        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("fcm", fcmEntity));
        criteria.add(Restrictions.between("startTime", date, next));
        List<ShowingEntity> showings = (List<ShowingEntity>) criteria.list();

        if (showings == null) return new ArrayList<ShowingEntity>();

        return showings;
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
