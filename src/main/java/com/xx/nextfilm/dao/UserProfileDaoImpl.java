package com.xx.nextfilm.dao;

import com.xx.nextfilm.entity.UserProfileEntity;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by CuiH on 2016/5/13.
 */
@Repository("userProfileDao")
public class UserProfileDaoImpl extends AbstractDao<Long, UserProfileEntity> implements UserProfileDao {

    public List<UserProfileEntity> findAll() {
        Criteria criteria = createEntityCriteria();
        criteria.addOrder(Order.asc("role"));
        return (List<UserProfileEntity>)criteria.list();
    }


    public UserProfileEntity findByRole(String role) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("role", role));
        return (UserProfileEntity) criteria.uniqueResult();
    }


    public UserProfileEntity findById(Long id) {
        return getByKey(id);
    }

}
