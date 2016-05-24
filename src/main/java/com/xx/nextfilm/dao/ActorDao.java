package com.xx.nextfilm.dao;

import com.xx.nextfilm.entity.ActorEntity;

import java.util.List;

/**
 * Created by CuiH on 2016/5/15.
 */
public interface ActorDao {

    ActorEntity findById(Long id);

    List<ActorEntity> findByName(String name);

    void doSave(ActorEntity actor);

    void doUpdate(ActorEntity actor);

    void doDelete(ActorEntity actor);

    List<ActorEntity> findAll();

}
