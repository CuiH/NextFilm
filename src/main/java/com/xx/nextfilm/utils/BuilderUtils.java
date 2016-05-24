package com.xx.nextfilm.utils;

import com.xx.nextfilm.dto.*;
import com.xx.nextfilm.entity.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by CuiH on 2016/5/23.
 */
public class BuilderUtils {

    private static ActorShower2 getActorShower2FromActorEntity(ActorEntity actor) {
        ActorShower2 actorShower2 = new ActorShower2();

        actorShower2.setId(actor.getId());
        actorShower2.setName(actor.getName());
        actorShower2.setImageUrl(actor.getImageUrl());

        return  actorShower2;
    }

    public static List<ActorShower2> getActorShower2sFromActorEntities(List<ActorEntity> actorEntities) {
        List<ActorShower2> actors = new ArrayList<ActorShower2>();

        if (actorEntities != null) {
            for (ActorEntity actor: actorEntities) {
                actors.add(BuilderUtils.getActorShower2FromActorEntity(actor));
            }
        }

        return actors;
    }


    private static FilmShower2 getFilmShower2FromFilmEntity(FilmEntity film) {
        FilmShower2 filmShower2 = new FilmShower2();

        filmShower2.setId(film.getId());
        filmShower2.setName(film.getName());
        filmShower2.setBrief(film.getBrief());
        filmShower2.setImageUrl(film.getImageUrl());
        film.setLanguage(film.getLanguage());

        return filmShower2;
    }


    private static FilmShower3 getFilmShower3FromFilmEntity(FilmEntity film) {
        FilmShower3 filmShower3 = new FilmShower3();

        filmShower3.setId(film.getId());
        filmShower3.setName(film.getName());

        return filmShower3;

    }

    public static List<FilmShower3> getFilmShower3sFromFilmEntities(List<FilmEntity> filmEntities) {
        List<FilmShower3> films = new ArrayList<FilmShower3>();

        if (filmEntities != null) {
            for (FilmEntity film: filmEntities) {
                films.add(BuilderUtils.getFilmShower3FromFilmEntity(film));
            }
        }

        return films;
    }


    public static HallShower1 getHallShower1FromHallEntity(HallEntity hall) {
        HallShower1 hallShower1 = new HallShower1();

        hallShower1.setId(hall.getId());
        hallShower1.setName(hall.getName());
        hallShower1.setType(hall.getType());
        hallShower1.setRowNum(ConverterUtils.convertShortToString(hall.getRowNum()));
        hallShower1.setColumnNum(ConverterUtils.convertShortToString(hall.getColumnNum()));

        return hallShower1;
    }

    public static List<HallShower1> getHallShower1sFromHallEntities(List<HallEntity> hallEntities) {
        List<HallShower1> halls = new ArrayList<HallShower1>();

        if (hallEntities != null) {
            for (HallEntity hall: hallEntities) {
                halls.add(BuilderUtils.getHallShower1FromHallEntity(hall));
            }
        }

        return halls;
    }


    private static HallShower2 getHallShower2FromHallEntity(HallEntity hall) {
        HallShower2 hallShower2 = new HallShower2();

        hallShower2.setId(hall.getId());
        hallShower2.setName(hall.getName());
        hallShower2.setType(hall.getType());

        return hallShower2;
    }

    public static List<HallShower2> getHallShower2sFromHallEntities(List<HallEntity> hallEntities) {
        List<HallShower2> halls = new ArrayList<HallShower2>();

        if (hallEntities != null) {
            for (HallEntity hall: hallEntities) {
                halls.add(BuilderUtils.getHallShower2FromHallEntity(hall));
            }
        }

        return  halls;
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


    private static ShowingShower2 getShowingShower2FromShowingEntity(ShowingEntity showing) {
        ShowingShower2 showingShower2 = new ShowingShower2();

        showingShower2.setId(showing.getId());
        showingShower2.setHall(BuilderUtils.getHallShower2FromHallEntity(showing.getHall()));
        showingShower2.setStartTime(ConverterUtils.convertDateToString(showing.getStartTime()));
        showingShower2.setEndTime(ConverterUtils.convertDateToString(showing.getEndTime()));
        showingShower2.setPriceManual(ConverterUtils.convertDoubleToString(showing.getPriceManual()));

        return showingShower2;
    }

    public static List<ShowingShower2> getShowingShower2sFromShowingEntities(List<ShowingEntity> showingEntities) {
        List<ShowingShower2> showings = new ArrayList<ShowingShower2>();

        if (showingEntities != null) {
            for (ShowingEntity showing: showingEntities) {
                showings.add(BuilderUtils.getShowingShower2FromShowingEntity(showing));
            }
        }

        return  showings;
    }


    private static FCMShower getFCMShowerFromFCMEntity(FCMEntity fcm) {
        FCMShower fcmShower = new FCMShower();

        fcmShower.setId(fcm.getId());
        fcmShower.setFilm(BuilderUtils.getFilmShower2FromFilmEntity(fcm.getFilm()));
        fcmShower.setShowings(BuilderUtils.getShowingShower2sFromShowingEntities(fcm.getShowings()));

        return fcmShower;
    }

    public static List<FCMShower> getFCMShowersFromFCMEntities(List<FCMEntity> fcmEntities) {
        List<FCMShower> fcms = new ArrayList<FCMShower>();

        if (fcmEntities != null) {
            for (FCMEntity fcm: fcmEntities) {
                fcms.add(BuilderUtils.getFCMShowerFromFCMEntity(fcm));
            }
        }

        return fcms;
    }

}
