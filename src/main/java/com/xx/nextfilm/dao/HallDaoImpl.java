package com.xx.nextfilm.dao;

import com.xx.nextfilm.dto.editor.HallEditor;
import com.xx.nextfilm.entity.HallEntity;
import com.xx.nextfilm.exception.HallNotExistException;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

/**
 * Created by CuiH on 2016/5/17.
 */
@Repository("hallDao")
public class HallDaoImpl extends AbstractDao<Long, HallEntity> implements HallDao {

    public HallEntity findById(Long id, boolean needCinema) {
        HallEntity hallEntity = getByKey(id);

        if (hallEntity == null) throw new HallNotExistException();

        if (needCinema) {
            Hibernate.initialize(hallEntity.getCinema());
        }

        return hallEntity;
    }


    public void doSave(HallEntity hall) {
        persist(hall);
    }


    public void doUpdate(HallEntity hall) {
        update(hall);
    }


    public boolean doUpdateManually(HallEditor hall) {
        String hql = "UPDATE hall set "+
                "name = :name, "+
                "type = :type, "+
                "row_num = :rowNum, "+
                "column_num = :columnNum "+
                "WHERE id = :id";
        Query query = createEntityQuery(hql);
        query.setParameter("name", hall.getName());
        query.setParameter("type", hall.getType());
        query.setParameter("rowNum", hall.getRowNum());
        query.setParameter("columnNum", hall.getColumnNum());
        query.setParameter("id", hall.getId());
        int l = query.executeUpdate();

        if (l == 0) return false;
        else return true;
    }


    public void doDelete(HallEntity hall) {
        delete(hall);
    }

}
