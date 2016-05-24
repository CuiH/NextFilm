package com.xx.nextfilm.utils;

import com.xx.nextfilm.dto.*;
import com.xx.nextfilm.entity.ActorEntity;
import com.xx.nextfilm.entity.FilmEntity;
import com.xx.nextfilm.entity.HallEntity;
import com.xx.nextfilm.entity.SeatEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by CuiH on 2016/5/23.
 */
public class BuilderUtils {

    public static ActorShower2 getActorShower2FromActorEntity(ActorEntity actor) {
        ActorShower2 actorShower2 = new ActorShower2();

        actorShower2.setId(actor.getId());
        actorShower2.setName(actor.getName());
        actorShower2.setImageUrl(actor.getImageUrl());

        return  actorShower2;
    }


    public static FilmShower3 getFilmShower3FromFilmEntity(FilmEntity film) {
        FilmShower3 filmShower3 = new FilmShower3();

        filmShower3.setId(film.getId());
        filmShower3.setName(film.getName());

        return filmShower3;

    }


    public static HallShower getHallShower1FromHallEntity(HallEntity hall) {
        HallShower hallShower = new HallShower();

        hallShower.setId(hall.getId());
        hallShower.setName(hall.getName());
        hallShower.setType(hall.getType());

        return hallShower;
    }


    public static SeatShower getSeatShower1FromSeatEntity(SeatEntity seat) {
        SeatShower seatShower = new SeatShower();

        seatShower.setId(seat.getId());
        seatShower.setRowPos(seat.getRowPos());
        seatShower.setColumnPos(seat.getColumnPos());
        seatShower.setStatus(seat.getStatus());

        return seatShower;
    }


    public static List<ShowingFilmShower> getShowingFilmShower(List<FilmShower3> allFilms, List<Long> showingFilms) {
        List<ShowingFilmShower> showingFilmShowers = new ArrayList<ShowingFilmShower>();
        for (FilmShower3 filmShower3: allFilms) {
            ShowingFilmShower showingFilmShower = new ShowingFilmShower();

            showingFilmShower.setId(filmShower3.getId());
            showingFilmShower.setName(filmShower3.getName());

            if (showingFilms.indexOf(showingFilmShower.getId()) != -1) showingFilmShower.setSelected(true);
            else showingFilmShower.setSelected(false);

            showingFilmShowers.add(showingFilmShower);
        }

        return  showingFilmShowers;
    }

}
