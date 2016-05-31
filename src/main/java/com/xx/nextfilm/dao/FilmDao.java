package com.xx.nextfilm.dao;

import com.xx.nextfilm.entity.FilmEntity;

import java.util.List;

/**
 * Created by CuiH on 2016/5/15.
 */
public interface FilmDao {

    FilmEntity findById(Long id, boolean needDirectors, boolean needActors);

    List<FilmEntity> findByName(String name, boolean needDirectors, boolean needActors);

    List<FilmEntity> findSome(int num, boolean needDirectors, boolean needActors);

    List<FilmEntity> findByAlias(String alias, boolean needDirectors, boolean needActors);

    List<FilmEntity> findByType(String type, boolean needDirectors, boolean needActors);

    List<FilmEntity> findByCategory(String category, boolean needDirectors, boolean needActors);

    void doSave(FilmEntity film);

    void doUpdate(FilmEntity film);

    void doDelete(FilmEntity film);

    List<FilmEntity> findAll(boolean needDirectors, boolean needActors);

}
