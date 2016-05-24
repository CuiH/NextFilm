package com.xx.nextfilm.service;

import com.xx.nextfilm.dto.ActorEditor;
import com.xx.nextfilm.dto.ActorShower1;
import com.xx.nextfilm.dto.ActorShower2;
import com.xx.nextfilm.entity.ActorEntity;

import java.util.HashMap;
import java.util.List;

/**
 * Created by CuiH on 2016/5/15.
 */
public interface ActorService {

    ActorEntity findActorById(Long id);

    ActorEditor getActorEditorById(Long id);

    List<ActorEntity> findActorsByName(String name);

    void createActor(ActorEditor actorEditor);

    void updateActor(ActorEditor actorEditor);

    void deleteActor(ActorEntity actorEntity);

    List<ActorEntity> findAllActors();

    List<ActorShower1> findAllActorsWithShower1();

    List<ActorShower2> findAllActorsWithShower2();

}
