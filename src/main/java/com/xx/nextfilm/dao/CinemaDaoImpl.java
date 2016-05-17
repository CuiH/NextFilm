package com.xx.nextfilm.dao;

import com.xx.nextfilm.entity.CinemaEntity;
import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by CuiH on 2016/5/16.
 */
@Repository("cinemaDao")
public class CinemaDaoImpl extends AbstractDao<Long, CinemaEntity> implements CinemaDao {

    public CinemaEntity findById(Long id, boolean needFilms, boolean needHalls) {
        CinemaEntity cinema = getByKey(id);

        if (needFilms) {
            if (cinema != null) {
                Hibernate.initialize(cinema.getFilms());
            }
        }

        if (needHalls) {
            if (cinema != null) {
                Hibernate.initialize(cinema.getHalls());
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


    public List<CinemaEntity> findAll(boolean needFilms, boolean needHalls) {
        Criteria criteria = createEntityCriteria().addOrder(Order.asc("name"));
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);//To avoid duplicates.
        List<CinemaEntity> cinemas = (List<CinemaEntity>) criteria.list();

        for (CinemaEntity cinema: cinemas) {
            if (needFilms) {
                if (cinema != null) {
                    Hibernate.initialize(cinema.getFilms());
                }
            }

            if (needHalls) {
                if (cinema != null) {
                    Hibernate.initialize(cinema.getHalls());
                }
            }
        }

        return cinemas;
    }

}
