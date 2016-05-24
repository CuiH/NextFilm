package com.xx.nextfilm.service;

import com.xx.nextfilm.dao.CinemaDao;
import com.xx.nextfilm.dao.FCMDao;
import com.xx.nextfilm.dao.FilmDao;
import com.xx.nextfilm.entity.CinemaEntity;
import com.xx.nextfilm.entity.FilmEntity;
import com.xx.nextfilm.exception.CinemaNotExistException;
import com.xx.nextfilm.exception.FilmNotExistException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by CuiH on 2016/5/24.
 */
@Transactional
@Service("fcmService")
public class FCMServiceImpl implements FCMService {

    @Autowired
    CinemaDao cinemaDao;

    @Autowired
    FilmDao filmDao;

    @Autowired
    FCMDao fcmDao;


    public void updateFCM(Long cinemaId, List<Long> filmIds)
            throws CinemaNotExistException, FilmNotExistException {
        CinemaEntity cinema = cinemaDao.findById(cinemaId, false, false, false);

        if (filmIds == null) {
            fcmDao.doUpdateManually(cinema, new ArrayList<FilmEntity>());

            return;
        }

        List<FilmEntity> films = new ArrayList<FilmEntity>();
        for (Long id: filmIds) {
            films.add(filmDao.findById(id, false, false));
        }

        fcmDao.doUpdateManually(cinema, films);
    }


}
