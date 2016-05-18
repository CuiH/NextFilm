package com.xx.nextfilm.dao;

import com.xx.nextfilm.entity.CinemaEntity;
import com.xx.nextfilm.entity.FCMEntity;
import com.xx.nextfilm.entity.FilmEntity;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

/**
 * Created by CuiH on 2016/5/18.
 */
@Repository("fcmDao")
public class FCMDaoImpl extends AbstractDao<Long, FCMEntity> implements FCMDao {

    public FCMEntity findByFilmAndCinema(FilmEntity film, CinemaEntity cinema) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("film", film));
        criteria.add(Restrictions.eq("cinema", cinema));
        FCMEntity fcm = (FCMEntity) criteria.uniqueResult();

        return fcm;
    }

}
