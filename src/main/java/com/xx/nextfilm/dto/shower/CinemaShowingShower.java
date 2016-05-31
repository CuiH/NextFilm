package com.xx.nextfilm.dto.shower;

import java.util.List;

/**
 * Created by CuiH on 2016/5/30.
 */
public class CinemaShowingShower {

    private CinemaShower2 cinema;

    private List<ShowingShower2> showings;


    public List<ShowingShower2> getShowings() {
        return showings;
    }

    public void setShowings(List<ShowingShower2> showings) {
        this.showings = showings;
    }


    public CinemaShower2 getCinema() {

        return cinema;
    }

    public void setCinema(CinemaShower2 cinema) {
        this.cinema = cinema;
    }

}
