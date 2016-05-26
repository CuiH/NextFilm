package com.xx.nextfilm.dto.shower;

import java.util.List;

/**
 * Created by CuiH on 2016/5/18.
 *
 * 用于场次详情页面
 */
public class ShowingShower1 {

    private Long id;

    private String startTime;
    private String endTime;
    private String priceManual;

    private List<SeatShower> seats;
    private FilmShower2 film;


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


    public List<SeatShower> getSeats() {
        return seats;
    }

    public void setSeats(List<SeatShower> seats) {
        this.seats = seats;
    }


    public FilmShower2 getFilm() {
        return film;
    }

    public void setFilm(FilmShower2 film) {
        this.film = film;
    }

}
