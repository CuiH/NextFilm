package com.xx.nextfilm.dao;

import com.xx.nextfilm.entity.UserEntity;
import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by CuiH on 2016/5/13.
 */
@Repository("userDao")
public class UserDaoImpl extends AbstractDao<Long, UserEntity> implements UserDao {

    public UserEntity findById(Long id, boolean needProfile, boolean needDetail) {
        UserEntity user = getByKey(id);

        if (needProfile) {
            if (user != null) {
                Hibernate.initialize(user.getUserProfiles());
            }
        }

        if (needDetail) {
            if (user != null) {
                Hibernate.initialize(user.getUserDetail());
            }
        }

        return user;
    }


    public UserEntity findByUsername(String username, boolean needProfile, boolean needDetail) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("username", username));
        UserEntity user = (UserEntity) criteria.uniqueResult();

        if (needProfile) {
            if (user != null) {
                Hibernate.initialize(user.getUserProfiles());
            }
        }

        if (needDetail) {
            if (user != null) {
                Hibernate.initialize(user.getUserDetail());
            }
        }

        return user;
    }


    public void doSave(UserEntity user) {
        persist(user);
    }


    public void doUpdate(UserEntity user) {
        update(user);
    }


    public void deleteByUsername(String username) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("username", username));
        UserEntity user = (UserEntity) criteria.uniqueResult();
        delete(user);
    }


    public void updateSingleFieldByUsername(String username, String field, String content) {
        String hql = "UPDATE user set "+field+" = :content "  +
                "WHERE username = :username";
        Query query = createEntityQuery(hql);
        query.setParameter("content", content);
        query.setParameter("username", username);
        query.executeUpdate();
    }


    public List<UserEntity> findAll(boolean needProfile, boolean needDetail) {
        Criteria criteria = createEntityCriteria().addOrder(Order.asc("username"));
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);//To avoid duplicates.
        List<UserEntity> users = (List<UserEntity>) criteria.list();


        for (UserEntity user: users) {
            if (needProfile) {
                if (user != null) {
                    Hibernate.initialize(user.getUserProfiles());
                }
            }

            if (needDetail) {
                if (user != null) {
                    Hibernate.initialize(user.getUserDetail());
                }
            }
        }

        return users;
    }

}
