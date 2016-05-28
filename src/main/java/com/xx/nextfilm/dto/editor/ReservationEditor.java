package com.xx.nextfilm.dto.editor;

import java.util.List;

/**
 * Created by cuihao on 2016/5/28.
 */
public class ReservationEditor {

    private List<String> seats;
    private Long showingId;


    public Long getShowingId() {
        return showingId;
    }

    public void setShowingId(Long showingId) {
        this.showingId = showingId;
    }


    public List<String> getSeats() {
        return seats;
    }

    public void setSeats(List<String> seats) {
        this.seats = seats;
    }

}
