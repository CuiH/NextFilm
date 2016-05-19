package com.xx.nextfilm.dao;

import com.xx.nextfilm.entity.UserDetailEntity;
import org.springframework.stereotype.Repository;

/**
 * Created by CuiH on 2016/5/15.
 */
@Repository("userDetailDao")
public class UserDetailDaoImpl extends AbstractDao<Long, UserDetailEntity> implements UserDetailDao {

    public UserDetailEntity findById(Long id) {
        return getByKey(id);
    }

    public void doUpdate(UserDetailEntity userDetail) {
        update(userDetail);
    }

    public void doSave(UserDetailEntity userDetail) {
        persist(userDetail);
    }
}
