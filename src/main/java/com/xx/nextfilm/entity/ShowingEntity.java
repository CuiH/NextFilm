package com.xx.nextfilm.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by CuiH on 2016/5/17.
 */
@Entity(name = "showing")
public class ShowingEntity {

    private Long id;
    private Date startTime;
    private Date endTime;
    private Double priceManual;

    // FCMEntity中对应项目，保存时用
    private FCMEntity fcm;
    // 同时加载放映厅信息
    private HallEntity hall;
    // 所有座位信息
    private List<SeatEntity> seats;


    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    @Basic
    @Column(name = "start_time")
    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }


    @Basic
    @Column(name = "end_time")
    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }


    @Basic
    @Column(name = "price_manual")
    public Double getPriceManual() {
        return priceManual;
    }

    public void setPriceManual(Double priceManual) {
        this.priceManual = priceManual;
    }


    @ManyToOne(fetch = FetchType.LAZY, optional = false, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "film_cinema_map_id")
    public FCMEntity getFcm() {
        return fcm;
    }

    public void setFcm(FCMEntity fcm) {
        this.fcm = fcm;
    }


    @ManyToOne(fetch = FetchType.EAGER, optional = false, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "hall_id")
    public HallEntity getHall() {
        return hall;
    }

    public void setHall(HallEntity hall) {
        this.hall = hall;
    }


    @OneToMany(fetch = FetchType.LAZY, mappedBy = "showing" ,cascade = CascadeType.REMOVE)
    public List<SeatEntity> getSeats() {
        return seats;
    }

    public void setSeats(List<SeatEntity> seats) {
        this.seats = seats;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ShowingEntity that = (ShowingEntity) o;

        if (id != that.id) return false;

        return true;
    }


    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));

        return result;
    }

}
