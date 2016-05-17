package com.xx.nextfilm.dao;

import com.xx.nextfilm.entity.FCMEntity;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

/**
 * Created by CuiH on 2016/5/18.
 */
@Repository("fcmDao")
public class FCMDaoImpl extends AbstractDao<Long, FCMEntity> implements FCMDao {

    public FCMEntity findByFilmAndCinema(Long filmId, Long cinemaId) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("film_id", filmId));
        criteria.add(Restrictions.eq("cinema_id", cinemaId));
        FCMEntity fcm = (FCMEntity) criteria.uniqueResult();

        return fcm;
    }

}
