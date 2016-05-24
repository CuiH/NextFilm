package com.xx.nextfilm.service;

import com.xx.nextfilm.dao.SeatDao;
import com.xx.nextfilm.entity.SeatEntity;
import com.xx.nextfilm.exception.SeatNotExistException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by CuiH on 2016/5/18.
 */
@Transactional
@Service("seatService")
public class SeatServiceImpl implements SeatService{

    @Autowired
    SeatDao seatDao;


    public SeatEntity findSeatById(Long id) throws SeatNotExistException {
        return seatDao.findById(id);
    }


    public void updateSeatStatus(Long id, String status) {
        seatDao.updateStatusById(id, status);
    }

}
