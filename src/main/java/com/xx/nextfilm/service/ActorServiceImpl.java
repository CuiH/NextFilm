package com.xx.nextfilm.service;

import com.xx.nextfilm.dao.ActorDao;
import com.xx.nextfilm.dto.ActorEditor;
import com.xx.nextfilm.dto.ActorShower1;
import com.xx.nextfilm.dto.ActorShower2;
import com.xx.nextfilm.entity.ActorEntity;
import com.xx.nextfilm.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * Created by CuiH on 2016/5/15.
 */
@Transactional
@Service("actorService")
public class ActorServiceImpl implements ActorService {

    @Autowired
    ActorDao dao;


    public ActorEntity findActorById(Long id) {
        return dao.findById(id);
    }


    public ActorEditor getActorEditorById(Long id) {
        ActorEntity actorEntity = findActorById(id);

        if (actorEntity == null) return null;

        ActorEditor actorEditor = new ActorEditor();
        actorEditor.setId(actorEntity.getId());
        actorEditor.setName(actorEntity.getName());
        actorEditor.setImageUrl(actorEntity.getImageUrl());
        actorEditor.setBrief(actorEntity.getBrief());
        actorEditor.setBirthday(Utils.convertDateToString(actorEntity.getBirthday()));

        return actorEditor;
    }


    public List<ActorEntity> findActorByName(String name) {
        return dao.findByName(name);
    }


    public void createActor(ActorEditor actorEditor) {
        dao.doSave(getEntityFromEditor(actorEditor, false));
    }


    public void updateActor(ActorEditor actorEditor) {
        dao.doUpdate(getEntityFromEditor(actorEditor, true));
    }


    public void deleteActor(ActorEntity actorEntity) {
        dao.doDelete(actorEntity);
    }


    public boolean deleteActorById(Long id) {
        return dao.deleteById(id);
    }


    public List<ActorEntity> findAllActors() {
        return dao.findAll();
    }


    public List<ActorShower1> findAllActorsWithShower1() {
        List<ActorEntity> actorEntities = findAllActors();

        if (actorEntities == null) return new ArrayList<ActorShower1>();

        List<ActorShower1>  actors = new ArrayList<ActorShower1>();
        for (ActorEntity actorEntity: actorEntities) {
            ActorShower1 actor = new ActorShower1();

            actor.setId(actorEntity.getId());
            actor.setName(actorEntity.getName());
            actor.setImageUrl(actorEntity.getImageUrl());
            actor.setBrief(actorEntity.getImageUrl());
            actor.setBirthday(Utils.convertDateToString(actorEntity.getBirthday()));

            actors.add(actor);
        }

        return actors;
    }


    public List<ActorShower2> findAllActorsWithShower2() {
        List<ActorEntity> actorEntities = findAllActors();

        if (actorEntities == null) return new ArrayList<ActorShower2>();

        List<ActorShower2>  actors = new ArrayList<ActorShower2>();
        for (ActorEntity actorEntity: actorEntities) {
            ActorShower2 actor = new ActorShower2();

            actor.setId(actorEntity.getId());
            actor.setName(actorEntity.getName());
            actor.setImageUrl(actorEntity.getImageUrl());

            actors.add(actor);
        }

        return actors;
    }


    private ActorEntity getEntityFromEditor(ActorEditor actorEditor, boolean needId) {
        ActorEntity actorEntity = new ActorEntity();

        if (needId) {
            actorEntity.setId(actorEditor.getId());
        }

        actorEntity.setName(actorEditor.getName());
        actorEntity.setBrief(actorEditor.getBrief());
        actorEntity.setImageUrl(actorEditor.getImageUrl());
        actorEntity.setBirthday(Utils.convertStringToDate(actorEditor.getBirthday()));

        return actorEntity;
    }


    public HashMap<Long, String> getAllActorsWithMap() {
        List<ActorEntity> allActors = findAllActors();

        HashMap<Long, String> map = new HashMap<Long, String>();
        for (ActorEntity actor: allActors) {
            map.put(actor.getId(), actor.getName());
        }

        return map;
    }

}
