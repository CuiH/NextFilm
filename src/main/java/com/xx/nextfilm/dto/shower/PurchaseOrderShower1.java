package com.xx.nextfilm.dto.shower;

import java.util.List;

/**
 * Created by cuihao on 2016/5/28.
 *
 * 用于订单详情页面
 *
 */
public class PurchaseOrderShower1 {

    private Long id;
    private String createTime;
    private String totalPrice;
    private String status;
    private Long filmId;
    private String filmName;
    private Long cinemaId;
    private String cinemaName;
    private String hallName;
    private String startTime;
    private String discount;
    private String seatNum;

    private List<OrderItemShower> orderItems;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }


    public String getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(String totalPrice) {
        this.totalPrice = totalPrice;
    }


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    public Long getFilmId() {
        return filmId;
    }

    public void setFilmId(Long filmId) {
        this.filmId = filmId;
    }


    public String getFilmName() {
        return filmName;
    }

    public void setFilmName(String filmName) {
        this.filmName = filmName;
    }


    public Long getCinemaId() {
        return cinemaId;
    }

    public void setCinemaId(Long cinemaId) {
        this.cinemaId = cinemaId;
    }


    public String getCinemaName() {
        return cinemaName;
    }

    public void setCinemaName(String cinemaName) {
        this.cinemaName = cinemaName;
    }


    public String getHallName() {
        return hallName;
    }

    public void setHallName(String hallName) {
        this.hallName = hallName;
    }


    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }


    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }


    public String getSeatNum() {
        return seatNum;
    }

    public void setSeatNum(String seatNum) {
        this.seatNum = seatNum;
    }


    public List<OrderItemShower> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItemShower> orderItems) {
        this.orderItems = orderItems;
    }


}
