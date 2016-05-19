package com.xx.nextfilm.dao;

import com.xx.nextfilm.entity.FilmEntity;
import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by CuiH on 2016/5/15.
 */
@Repository("filmDao")
public class FilmDaoImpl extends AbstractDao<Long, FilmEntity> implements FilmDao {

    public FilmEntity findById(Long id, boolean needDirectors, boolean needActors) {
        FilmEntity film = getByKey(id);

        if (needDirectors && film != null) {
            Hibernate.initialize(film.getDirectors());
        }

        if (needActors && film != null) {
            Hibernate.initialize(film.getActors());
        }

        return film;
    }


    public List<FilmEntity> findByName(String name) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("name", name));
        List<FilmEntity> films = (List<FilmEntity>) criteria.list();

        return films;
    }


    public List<FilmEntity> findByAlias(String alias) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("alias", alias));
        List<FilmEntity> films = (List<FilmEntity>) criteria.list();

        return films;
    }


    public List<FilmEntity> findByType(String type) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("type", type));
        List<FilmEntity> films = (List<FilmEntity>) criteria.list();

        return films;
    }


    public List<FilmEntity> findByCategory(String category) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("category", category));
        List<FilmEntity> films = (List<FilmEntity>) criteria.list();

        return films;
    }


    public void doSave(FilmEntity film) {
        persist(film);
    }


    public void doUpdate(FilmEntity film) {
        update(film);
    }


    public void doDelete(FilmEntity film) {
        delete(film);
    }


    public List<FilmEntity> findAll(boolean needDirectors, boolean needActors) {
        Criteria criteria = createEntityCriteria().addOrder(Order.asc("name"));
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);//To avoid duplicates.
        List<FilmEntity> films = (List<FilmEntity>) criteria.list();

        if (needDirectors && films != null) {
            for (FilmEntity film: films) {
                Hibernate.initialize(film.getDirectors());
            }
        }


        if (needActors && films != null) {
            for (FilmEntity film: films) {
                Hibernate.initialize(film.getActors());
            }
        }

        return films;
    }

}
