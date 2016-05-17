package com.xx.nextfilm.dao;

import com.xx.nextfilm.entity.CinemaEntity;

import java.util.List;

/**
 * Created by CuiH on 2016/5/16.
 */
public interface CinemaDao {

    CinemaEntity findById(Long id, boolean needFilms, boolean needHalls);

    List<CinemaEntity> findByName(String name);

    List<CinemaEntity> findByCityCode(String cityCode);

    void doSave(CinemaEntity cinema);

    void doDelete(CinemaEntity cinema);

    void doUpdate(CinemaEntity cinema);

    List<CinemaEntity> findAll(boolean needFilms, boolean needHalls);

}
