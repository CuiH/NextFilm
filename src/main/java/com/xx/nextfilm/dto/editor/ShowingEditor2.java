package com.xx.nextfilm.dto.editor;

import com.xx.nextfilm.dto.shower.SeatShower;
import org.hibernate.validator.constraints.NotEmpty;

import java.util.List;

/**
 * Created by CuiH on 2016/5/19.
 *
 * 用在编辑页面
 */
public class ShowingEditor2 {

    private Long id;
    @NotEmpty
    private String startTime;
    @NotEmpty
    private String endTime;
    @NotEmpty
    private String priceManual;

    private String filmName;
    private String hallName;

    private List<SeatShower> seats;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }


    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }


    public String getPriceManual() {
        return priceManual;
    }

    public void setPriceManual(String priceManual) {
        this.priceManual = priceManual;
    }


    public String getFilmName() {
        return filmName;
    }

    public void setFilmName(String filmName) {
        this.filmName = filmName;
    }


    public String getHallName() {
        return hallName;
    }

    public void setHallName(String hallName) {
        this.hallName = hallName;
    }


    public List<SeatShower> getSeats() {
        return seats;
    }

    public void setSeats(List<SeatShower> seats) {
        this.seats = seats;
    }

}
