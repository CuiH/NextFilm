package com.xx.nextfilm.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by CuiH on 2016/5/17.
 */
@Entity(name = "show")
public class ShowEntity {

    private Long id;
    private Date startTime;
    private Date endTime;
    private Double priceManual;


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


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ShowEntity that = (ShowEntity) o;

        if (id != that.id) return false;

        return true;
    }


    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));

        return result;
    }

}
