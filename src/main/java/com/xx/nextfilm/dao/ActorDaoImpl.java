package com.xx.nextfilm.dao;

import com.xx.nextfilm.entity.ActorEntity;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by CuiH on 2016/5/15.
 */
@Repository("actorDao")
public class ActorDaoImpl extends AbstractDao<Long, ActorEntity> implements ActorDao {

    public ActorEntity findById(Long id) {
        if (id == null) return null;
        else return getByKey(id);
    }


    public List<ActorEntity> findByName(String name) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("name", name));
        List<ActorEntity> actors = (List<ActorEntity>) criteria.list();

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


    public boolean deleteById(Long id) {
        String hql = "DELETE from actor WHERE id = :id";
        Query query = createEntityQuery(hql);
        query.setParameter("id", id);
        int l = query.executeUpdate();

        System.out.println("adasdasdasdasdasd++++"+l);

        if (l == 0) return false;
        else return true;
    }

    
    public List<ActorEntity> findAll() {
        Criteria criteria = createEntityCriteria().addOrder(Order.asc("name"));
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);//To avoid duplicates.
        List<ActorEntity> actors = (List<ActorEntity>) criteria.list();

        return actors;
    }

}
