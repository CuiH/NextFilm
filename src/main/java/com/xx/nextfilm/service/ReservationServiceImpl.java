package com.xx.nextfilm.service;

import com.xx.nextfilm.controller.back.MainController;
import com.xx.nextfilm.dao.PurchaseOrderDao;
import com.xx.nextfilm.dao.SeatDao;
import com.xx.nextfilm.dao.ShowingDao;
import com.xx.nextfilm.dto.editor.ReservationEditor;
import com.xx.nextfilm.entity.*;
import com.xx.nextfilm.exception.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * Created by cuihao on 2016/5/27.
 */
@Transactional
@Service("reservationService")
public class ReservationServiceImpl implements ReservationService {

    private static final Logger LOG = LogManager.getLogger("com.xx.nextfilm");

    @Autowired
    PurchaseOrderDao purchaseOrderDao;

    @Autowired
    ShowingDao showingDao;

    @Autowired
    SeatDao seatDao;


    public void makeReservation(UserEntity user, ReservationEditor reservation)
            throws ShowingNotExistException {
        ShowingEntity showing = showingDao.findById(reservation.getShowingId(), true, true, true);

        List<SeatEntity> seats = showing.getSeats();
        if (seats == null) throw new SeatNotExistException();

        HashMap<String, SeatEntity> map = new HashMap<String, SeatEntity>();
        for (SeatEntity seat: seats) {
            String serial = "" + seat.getRowPos() + "T" + seat.getColumnPos();
            map.put(serial, seat);
        }

        PurchaseOrderEntity purchaseOrder = new PurchaseOrderEntity();

        List<OrderItemEntity> orderItems = new ArrayList<OrderItemEntity>();
        for (String serial: reservation.getSeats()) {
            SeatEntity seat = map.get(serial);
            if (seat == null) throw new SeatNotExistException();

            // 可优化
            if (seat.getStatus().equals("0")) throw new SeatHasBeenReservedException();

            OrderItemEntity orderItem = new OrderItemEntity();
            orderItem.setRow(seat.getRowPos());
            orderItem.setColumn(seat.getColumnPos());
            // 价格可变
            orderItem.setPrice(showing.getPriceManual());

            orderItems.add(orderItem);

            // seat信息
            seatDao.updateStatusById(seat.getId(), "0");

            orderItem.setPurchaseOrder(purchaseOrder);
        }

        purchaseOrder.setSeatNum(Short.parseShort("" + orderItems.size()));

        purchaseOrder.setCinemaId(showing.getFcm().getCinema().getId());
        purchaseOrder.setCinemaName(showing.getFcm().getCinema().getName());
        purchaseOrder.setFilmId(showing.getFcm().getFilm().getId());
        purchaseOrder.setFilmName(showing.getFcm().getFilm().getName());
        purchaseOrder.setFilmImageUrl(showing.getFcm().getFilm().getImageUrl());
        purchaseOrder.setHallName(showing.getHall().getName());
        // 可变
        purchaseOrder.setDiscount(0d);
        purchaseOrder.setStatus("已预订");
        purchaseOrder.setStartTime(showing.getStartTime());

        Date now = new Date();
        purchaseOrder.setCreateTime(now);

        Double total = 0d;
        for (OrderItemEntity orderItem: orderItems) {
            total += orderItem.getPrice();
        }
        purchaseOrder.setTotalPrice(total);

        purchaseOrder.setOrderItems(orderItems);

        purchaseOrder.setUser(user);

        purchaseOrderDao.doSave(purchaseOrder);

        LOG.info(user.getUsername() + " : make reservation - user_id#" + user.getId() + ", showing_id#"
                + showing.getId() + ", seat@" + String.join(" ", reservation.getSeats()));
    }


    public void deleteReservation(PurchaseOrderEntity purchaseOrder) throws UserNotLoginException {
        purchaseOrderDao.doDelete(purchaseOrder);

        LOG.info(MainController.getCurrentUsername() + " : delete reservation - #" + purchaseOrder.getId());
    }


    public PurchaseOrderEntity findReservationById(Long id, boolean needOrderItems)
            throws PurchaseOrderNotExistException {
        return purchaseOrderDao.findById(id, needOrderItems);
    }


    public List<PurchaseOrderEntity> findReservationsByUser(UserEntity user, boolean needOrderItems) {
        return purchaseOrderDao.findByUser(user, needOrderItems);
    }

}
