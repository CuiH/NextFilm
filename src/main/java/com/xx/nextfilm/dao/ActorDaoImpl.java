package com.xx.nextfilm.dao;

import com.xx.nextfilm.entity.ActorEntity;
import com.xx.nextfilm.exception.ActorNotExistException;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by CuiH on 2016/5/15.
 */
@Repository("actorDao")
public class ActorDaoImpl extends AbstractDao<Long, ActorEntity> implements ActorDao {

    public ActorEntity findById(Long id) {
        ActorEntity actorEntity = getByKey(id);

        if (actorEntity == null) throw new ActorNotExistException();

        return actorEntity;
    }


    public List<ActorEntity> findByName(String name) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.like("name", "%"+name+"%"));
        List<ActorEntity> actors = (List<ActorEntity>) criteria.list();

        if (actors == null) return new ArrayList<ActorEntity>();

        return actors;
    }


    public void doSave(ActorEntity actor) {
        persist(actor);
    }


    public void doUpdate(ActorEntity actor) {
        update(actor);
    }


    public void doDelete(ActorEntity actor) {
        delete(actor);
    }

    
    public List<ActorEntity> findAll() {
        Criteria criteria = createEntityCriteria().addOrder(Order.asc("name"));
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);//To avoid duplicates.
        List<ActorEntity> actors = (List<ActorEntity>) criteria.list();

        if (actors == null) return new ArrayList<ActorEntity>();

        return actors;
    }

}
