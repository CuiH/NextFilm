package com.xx.nextfilm.dao;

import com.xx.nextfilm.entity.FilmEntity;
import com.xx.nextfilm.exception.FilmNotExistException;
import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.security.access.method.P;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by CuiH on 2016/5/15.
 */
@Repository("filmDao")
public class FilmDaoImpl extends AbstractDao<Long, FilmEntity> implements FilmDao {

    public FilmEntity findById(Long id, boolean needDirectors, boolean needActors) {
        FilmEntity film = getByKey(id);

        if (film == null) throw new FilmNotExistException();

        if (needDirectors) {
            Hibernate.initialize(film.getDirectors());
        }

        if (needActors) {
            Hibernate.initialize(film.getActors());
        }

        return film;
    }


    public List<FilmEntity> findByName(String name, boolean needDirectors, boolean needActors) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.or(Restrictions.like("name", name, MatchMode.ANYWHERE),
                Restrictions.like("alias", name, MatchMode.ANYWHERE)));
        List<FilmEntity> films = (List<FilmEntity>) criteria.list();

        if (films == null) return new ArrayList<FilmEntity>();

        for (FilmEntity filmEntity: films) {
            if (needActors) {
                Hibernate.initialize(filmEntity.getActors());
            }

            if (needDirectors) {
                Hibernate.initialize(filmEntity.getDirectors());
            }
        }

        return films;
    }


    public List<FilmEntity> findSome(int num, boolean needDirectors, boolean needActors) {
        Criteria criteria = createEntityCriteria();
        criteria.setMaxResults(num);
        List<FilmEntity> films = (List<FilmEntity>) criteria.list();

        if (films == null) return new ArrayList<FilmEntity>();

        for (FilmEntity filmEntity: films) {
            if (needActors) {
                Hibernate.initialize(filmEntity.getActors());
            }
        }

        if (needDirectors) {
            for (FilmEntity filmEntity: films) {
                Hibernate.initialize(filmEntity.getDirectors());
            }
        }

        return films;
    }


    public List<FilmEntity> findByAlias(String alias, boolean needDirectors, boolean needActors) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.like("alias", "%"+alias+"%"));
        List<FilmEntity> films = (List<FilmEntity>) criteria.list();

        if (films == null) return new ArrayList<FilmEntity>();

        if (needDirectors) {
            for (FilmEntity filmEntity: films) {
                Hibernate.initialize(filmEntity.getDirectors());
            }
        }

        for (FilmEntity filmEntity: films) {
            if (needActors) {
                Hibernate.initialize(filmEntity.getActors());
            }
        }

        return films;
    }


    public List<FilmEntity> findByType(String type, boolean needDirectors, boolean needActors) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("type", type));
        List<FilmEntity> films = (List<FilmEntity>) criteria.list();

        if (films == null) return new ArrayList<FilmEntity>();

        for (FilmEntity filmEntity: films) {
            if (needDirectors) {
                Hibernate.initialize(filmEntity.getDirectors());
            }

            if (needActors) {
                Hibernate.initialize(filmEntity.getActors());
            }
        }

        return films;
    }


    public List<FilmEntity> findByCategory(String category, boolean needDirectors, boolean needActors) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("category", category));
        List<FilmEntity> films = (List<FilmEntity>) criteria.list();

        if (films == null) return new ArrayList<FilmEntity>();

        for (FilmEntity filmEntity: films) {
            if (needDirectors) {
                Hibernate.initialize(filmEntity.getDirectors());
            }
        }

        if (needActors) {
            for (FilmEntity filmEntity: films) {
                Hibernate.initialize(filmEntity.getActors());
            }
        }

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

        if (films == null) return new ArrayList<FilmEntity>();

        if (needDirectors) {
            for (FilmEntity film: films) {
                Hibernate.initialize(film.getDirectors());
            }
        }


        if (needActors) {
            for (FilmEntity film: films) {
                Hibernate.initialize(film.getActors());
            }
        }

        return films;
    }

}
