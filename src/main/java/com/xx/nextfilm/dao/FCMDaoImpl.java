package com.xx.nextfilm.dao;

import com.xx.nextfilm.entity.CinemaEntity;
import com.xx.nextfilm.entity.FCMEntity;
import com.xx.nextfilm.entity.FilmEntity;
import com.xx.nextfilm.exception.FCMNotExistException;
import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

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

        if (fcm == null) throw new FCMNotExistException();

        return fcm;
    }


    public List<FCMEntity> findSomeByFilm(FilmEntity film, int num) {
        Criteria criteria = createEntityCriteria();
        criteria.setMaxResults(num);
        criteria.add(Restrictions.eq("film", film));
        List<FCMEntity> fcms = (List<FCMEntity>) criteria.list();

        if (fcms == null) return new ArrayList<FCMEntity>();

        // 同时加载fcm中cinema信息
        for (FCMEntity fcm: fcms) {
            Hibernate.initialize(fcm.getCinema());
        }

        return fcms;
    }


    public void doUpdateManually(CinemaEntity cinema, List<FilmEntity> films) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("cinema", cinema));
        List<FCMEntity> fcms = (List<FCMEntity>) criteria.list();

        if (fcms == null) fcms = new ArrayList<FCMEntity>();

        for (FCMEntity fcm: fcms) {
            Hibernate.initialize(fcm.getFilm());
        }

        // 找到所有新的电影
        List<FilmEntity> newFilms = new ArrayList<FilmEntity>();
        for (FilmEntity film: films) {
            boolean flag = false;
            for (FCMEntity fcm: fcms) {
                if (fcm.getFilm().getId() == film.getId()) {
                    flag = true;
                    break;
                }
            }
            if (flag == false) {
                newFilms.add(film);
            }
        }

        // 找到所有要删除的电影
        List<FCMEntity> deletedFcms = new ArrayList<FCMEntity>();
        for (FCMEntity fcm: fcms) {
            boolean flag = false;
            for (FilmEntity film: films) {
                if (film.getId() == fcm.getFilm().getId()) {
                    flag = true;
                    break;
                }
            }
            if (flag == false) {
                deletedFcms.add(fcm);
            }
        }

        for (FCMEntity fcm: deletedFcms) {
            delete(fcm);
        }

        for (FilmEntity film: newFilms) {
            FCMEntity fcmEntity = new FCMEntity();

            fcmEntity.setCinema(cinema);
            fcmEntity.setFilm(film);

            persist(fcmEntity);
        }
    }
}
