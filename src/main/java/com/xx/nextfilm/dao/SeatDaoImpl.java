package com.xx.nextfilm.dao;

import com.xx.nextfilm.entity.SeatEntity;
import com.xx.nextfilm.exception.SeatNotExistException;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

/**
 * Created by CuiH on 2016/5/18.
 */
@Repository("seatDao")
public class SeatDaoImpl extends AbstractDao<Long, SeatEntity> implements SeatDao {

    public SeatEntity findById(Long id) {
        SeatEntity seatEntity = getByKey(id);

        if (seatEntity == null) throw new SeatNotExistException();

        return seatEntity;
    }


    public SeatEntity findBySerialNum(String serialNum) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("serial_num", serialNum));

        SeatEntity seatEntity = (SeatEntity) criteria.uniqueResult();

        return  seatEntity;
    }


    public void doSave(SeatEntity seat) {
        persist(seat);
    }


    public void updateStatusById(Long id, String status) {
        String hql = "UPDATE seat set status = :status "  +
                "WHERE id = :id";
        Query query = createEntityQuery(hql);
        query.setParameter("status", status);
        query.setParameter("id", id);
        query.executeUpdate();
    }

}
