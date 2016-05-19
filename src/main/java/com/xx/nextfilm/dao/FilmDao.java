package com.xx.nextfilm.dao;

import com.xx.nextfilm.entity.FilmEntity;

import java.util.List;

/**
 * Created by CuiH on 2016/5/15.
 */
public interface FilmDao {

    FilmEntity findById(Long id, boolean needDirectors, boolean needActors);

    List<FilmEntity> findByName(String name);

    List<FilmEntity> findByAlias(String alias);

    List<FilmEntity> findByType(String type);

    List<FilmEntity> findByCategory(String category);

    void doSave(FilmEntity film);

    void doUpdate(FilmEntity film);

    void doDelete(FilmEntity film);

    List<FilmEntity> findAll(boolean needDirectors, boolean needActors);

}
