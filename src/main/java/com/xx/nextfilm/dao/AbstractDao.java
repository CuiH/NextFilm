package com.xx.nextfilm.dao;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;

/**
 * Created by CuiH on 2016/5/13.
 */
public abstract class AbstractDao<PK extends Serializable, T> {

    @Autowired
    private SessionFactory sessionFactory;

    private final Class<T> persistentClass;


    @SuppressWarnings("unchecked")
    public AbstractDao(){
        this.persistentClass =(Class<T>) ((ParameterizedType) this.getClass()
                .getGenericSuperclass()).getActualTypeArguments()[1];
    }


    protected Session getSession(){
        return sessionFactory.getCurrentSession();
    }


    @SuppressWarnings("unchecked")
    public T getByKey(PK key) {
        return getSession().get(persistentClass, key);
    }


    public void persist(T entity) {
        getSession().persist(entity);
    }


    public void update(T entity) {
        getSession().update(entity);
    }


    public void delete(T entity) {
        getSession().delete(entity);
    }


    protected Criteria createEntityCriteria(){
        return getSession().createCriteria(persistentClass);
    }


    protected Query createEntityQuery(String hql) {
            return getSession().createQuery(hql);
    }


}
