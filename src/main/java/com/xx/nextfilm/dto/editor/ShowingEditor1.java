package com.xx.nextfilm.dto.editor;

import com.xx.nextfilm.dto.shower.FilmShower3;
import com.xx.nextfilm.entity.SeatEntity;
import org.hibernate.validator.constraints.NotEmpty;

import java.util.Date;
import java.util.List;

/**
 * Created by CuiH on 2016/5/17.
 *
 * 用在新建页面
 */
public class ShowingEditor1 {

    private Long id;
    @NotEmpty
    private String startTime;
    @NotEmpty
    private String endTime;
    @NotEmpty
    private String priceManual;

    private FilmShower3 film;

    private Long cinemaId;
    private Long hallId;
    private Long filmId;


    public Long getCinemaId() {
        return cinemaId;
    }

    public void setCinemaId(Long cinemaId) {
        this.cinemaId = cinemaId;
    }


    public Long getHallId() {
        return hallId;
    }

    public void setHallId(Long hallId) {
        this.hallId = hallId;
    }


    public Long getFilmId() {
        return filmId;
    }

    public void setFilmId(Long filmId) {
        this.filmId = filmId;
    }


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


    public FilmShower3 getFilm() {
        return film;
    }

    public void setFilm(FilmShower3 film) {
        this.film = film;
    }

}
