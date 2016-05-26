package com.xx.nextfilm.dto.shower;

import java.util.List;

/**
 * Created by CuiH on 2016/5/18.
 *
 * 用于影院详情页面（放在cinema中），及场次详情页面（放在showing中）
 */
public class FCMShower {

    private Long id;

    private FilmShower2 film;
    private List<ShowingShower2> showings;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public FilmShower2 getFilm() {
        return film;
    }

    public void setFilm(FilmShower2 film) {
        this.film = film;
    }


    public List<ShowingShower2> getShowings() {
        return showings;
    }

    public void setShowings(List<ShowingShower2> showings) {
        this.showings = showings;
    }

}
