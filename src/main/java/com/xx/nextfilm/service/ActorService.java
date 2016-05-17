package com.xx.nextfilm.service;

import com.xx.nextfilm.dto.ActorEditor;
import com.xx.nextfilm.entity.ActorEntity;

import java.util.HashMap;
import java.util.List;

/**
 * Created by CuiH on 2016/5/15.
 */
public interface ActorService {

    ActorEntity findActorById(Long id);

    ActorEditor getActorEditorById(Long id);

    List<ActorEntity> findActorByName(String name);

    void createActor(ActorEditor actorEditor);

    void updateActor(ActorEditor actorEditor);

    void deleteActor(ActorEntity actorEntity);

    boolean deleteActorById(Long id);

    List<ActorEntity> findAllActors();

    HashMap<Long, String> getAllActorsWithMap();

}
