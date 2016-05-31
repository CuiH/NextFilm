package com.xx.nextfilm.dto.shower;

import java.util.List;

/**
 * Created by CuiH on 2016/5/30.
 */
public class FilmShowingShower {

    private FilmShower2 film;

    private List<ShowingShower2> showings;


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
