package com.xx.nextfilm.service;

import com.xx.nextfilm.controller.back.MainController;
import com.xx.nextfilm.dao.ActorDao;
import com.xx.nextfilm.dto.editor.ActorEditor;
import com.xx.nextfilm.dto.shower.ActorShower1;
import com.xx.nextfilm.dto.shower.ActorShower2;
import com.xx.nextfilm.entity.ActorEntity;
import com.xx.nextfilm.exception.ActorNotExistException;
import com.xx.nextfilm.exception.UserNotLoginException;
import com.xx.nextfilm.utils.BuilderUtils;
import com.xx.nextfilm.utils.ConverterUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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

    private static final Logger LOG = LogManager.getLogger("com.xx.nextfilm");

    @Autowired
    ActorDao dao;


    public ActorEntity findActorById(Long id) throws ActorNotExistException {
        return dao.findById(id);
    }


    public ActorEditor getActorEditorById(Long id) throws ActorNotExistException {
        ActorEntity actorEntity = findActorById(id);

        ActorEditor actorEditor = new ActorEditor();
        actorEditor.setId(actorEntity.getId());
        actorEditor.setName(actorEntity.getName());
        actorEditor.setImageUrl(actorEntity.getImageUrl());
        actorEditor.setBrief(actorEntity.getBrief());
        actorEditor.setBirthday(ConverterUtils.convertDateToString(actorEntity.getBirthday()));

        return actorEditor;
    }


    public List<ActorEntity> findActorsByName(String name) {
        return dao.findByName(name);
    }


    public void createActor(ActorEditor actorEditor) throws UserNotLoginException {
        ActorEntity actorEntity = getEntityFromEditor(actorEditor, false);
        dao.doSave(actorEntity);

        LOG.info(MainController.getCurrentUsername() + " : add actor - #" + actorEntity.getId());
    }


    public void updateActor(ActorEditor actorEditor) throws UserNotLoginException {
        dao.doUpdate(getEntityFromEditor(actorEditor, true));

        LOG.info(MainController.getCurrentUsername() + " : edit actor - #" + actorEditor.getId());
    }


    public void deleteActor(ActorEntity actorEntity) throws UserNotLoginException{
        dao.doDelete(actorEntity);

        LOG.info(MainController.getCurrentUsername() + " : delete actor - #" + actorEntity.getId());
    }


    public List<ActorEntity> findAllActors() {
        return dao.findAll();
    }


    public List<ActorShower1> findAllActorsWithShower1() {
        List<ActorEntity> actorEntities = findAllActors();

        List<ActorShower1>  actors = new ArrayList<ActorShower1>();
        for (ActorEntity actorEntity: actorEntities) {
            ActorShower1 actor = new ActorShower1();

            actor.setId(actorEntity.getId());
            actor.setName(actorEntity.getName());
            actor.setImageUrl(actorEntity.getImageUrl());
            actor.setBrief(actorEntity.getBrief());
            actor.setBirthday(ConverterUtils.convertDateToString(actorEntity.getBirthday()));

            actors.add(actor);
        }

        return actors;
    }


    public List<ActorShower2> findAllActorsWithShower2() {
        List<ActorEntity> actorEntities = findAllActors();

        return BuilderUtils.getActorShower2sFromActorEntities(actorEntities);
    }


    private ActorEntity getEntityFromEditor(ActorEditor actorEditor, boolean needId) {
        ActorEntity actorEntity = new ActorEntity();

        if (needId) {
            actorEntity.setId(actorEditor.getId());
        }

        actorEntity.setName(actorEditor.getName());
        actorEntity.setBrief(actorEditor.getBrief());
        actorEntity.setImageUrl(actorEditor.getImageUrl());
        actorEntity.setBirthday(ConverterUtils.convertStringToDate(actorEditor.getBirthday()));

        return actorEntity;
    }

}
