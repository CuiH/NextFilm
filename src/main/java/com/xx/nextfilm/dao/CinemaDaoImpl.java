package com.xx.nextfilm.dao;

import com.xx.nextfilm.entity.CinemaEntity;
import com.xx.nextfilm.entity.FCMEntity;
import com.xx.nextfilm.exception.CinemaNotExistException;
import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by CuiH on 2016/5/16.
 */
@Repository("cinemaDao")
public class CinemaDaoImpl extends AbstractDao<Long, CinemaEntity> implements CinemaDao {

    public CinemaEntity findById(Long id, boolean needFilms, boolean needHalls, boolean needFcms) {
        CinemaEntity cinema = getByKey(id);

        if (cinema == null) throw new CinemaNotExistException();

        if (needFilms) {
            Hibernate.initialize(cinema.getFilms());
        }

        if (needHalls) {
            Hibernate.initialize(cinema.getHalls());
        }

        if (needFcms) {
            Hibernate.initialize(cinema.getFcms());

            //　同时加载FCM中所有上映信息
            List<FCMEntity> fcms = cinema.getFcms();
            if (fcms != null) {
                for (FCMEntity fcm: fcms) {
                    Hibernate.initialize(fcm.getFilm());
                    Hibernate.initialize(fcm.getShowings());
                }
            }
        }

        return cinema;
    }


    public List<CinemaEntity> findByName(String name) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("name", name));
        List<CinemaEntity> cinemas = (List<CinemaEntity>) criteria.list();

        return cinemas;
    }


    public List<CinemaEntity> findByCityCode(String cityCode) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("city_code", cityCode));
        List<CinemaEntity> cinemas = (List<CinemaEntity>) criteria.list();

        return cinemas;
    }


    public void doSave(CinemaEntity cinema) {
        persist(cinema);
    }


    public void doDelete(CinemaEntity cinema) {
        delete(cinema);
    }


    public void doUpdate(CinemaEntity cinema) {
        update(cinema);
    }


    public boolean doUpdateManually(CinemaEntity cinema) {
        String hql = "UPDATE cinema set "+
                "name = :name, "+
                "city_code = :cityCode, "+
                "address = :address, "+
                "phone = :phone, "+
                "brief = :brief, "+
                "image_url = :imageUrl, "+
                "description = :description "+
                "WHERE id = :id";
        Query query = createEntityQuery(hql);
        query.setParameter("name", cinema.getName());
        query.setParameter("cityCode", cinema.getCityCode());
        query.setParameter("address", cinema.getAddress());
        query.setParameter("phone", cinema.getPhone());
        query.setParameter("brief", cinema.getBrief());
        query.setParameter("imageUrl", cinema.getImageUrl());
        query.setParameter("description", cinema.getDescription());
        query.setParameter("id", cinema.getId());
        int l = query.executeUpdate();

        if (l == 0) return false;
        else return true;
    }


    public List<CinemaEntity> findAll(boolean needFilms, boolean needHalls, boolean needFcms) {
        Criteria criteria = createEntityCriteria().addOrder(Order.asc("name"));
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);//To avoid duplicates.
        List<CinemaEntity> cinemas = (List<CinemaEntity>) criteria.list();

        if (cinemas == null) return new ArrayList<CinemaEntity>();

        for (CinemaEntity cinema: cinemas) {
            if (needFilms) {
                Hibernate.initialize(cinema.getFilms());
            }

            if (needHalls) {
                Hibernate.initialize(cinema.getHalls());
            }

            if (needFcms) {
                Hibernate.initialize(cinema.getFcms());
            }
        }

        return cinemas;
    }

}
