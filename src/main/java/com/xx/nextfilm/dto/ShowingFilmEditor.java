package com.xx.nextfilm.dto;

import java.util.List;

/**
 * Created by CuiH on 2016/5/24.
 */
public class ShowingFilmEditor {

    private Long cinemaId;

    private List<Long> filmIds;


    public Long getCinemaId() {
        return cinemaId;
    }

    public void setCinemaId(Long cinemaId) {
        this.cinemaId = cinemaId;
    }


    public List<Long> getFilmIds() {
        return filmIds;
    }

    public void setFilmIds(List<Long> filmIds) {
        this.filmIds = filmIds;
    }

}
