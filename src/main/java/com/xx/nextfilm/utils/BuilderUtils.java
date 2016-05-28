package com.xx.nextfilm.utils;

import com.xx.nextfilm.dto.shower.*;
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

    public static List<FilmShower2> getFilmShower2sFromFilmEntities(List<FilmEntity> filmEntities) {
        List<FilmShower2> films = new ArrayList<FilmShower2>();

        if (filmEntities != null) {
            for (FilmEntity film: filmEntities) {
                films.add(BuilderUtils.getFilmShower2FromFilmEntity(film));
            }
        }

        return films;
    }


    public static FilmShower3 getFilmShower3FromFilmEntity(FilmEntity film) {
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


    public static SeatShower getSeatShowerFromSeatEntity(SeatEntity seat) {
        SeatShower seatShower = new SeatShower();

        seatShower.setId(seat.getId());
        seatShower.setRowPos(seat.getRowPos());
        seatShower.setColumnPos(seat.getColumnPos());
        seatShower.setStatus(seat.getStatus());

        return seatShower;
    }

    public static List<SeatShower> getSeatShowersFromSeatEntities(List<SeatEntity> seatEntities) {
        List<SeatShower> seats = new ArrayList<SeatShower>();

        if (seatEntities != null) {
            for (SeatEntity seat: seatEntities) {
                seats.add(BuilderUtils.getSeatShowerFromSeatEntity(seat));
            }
        }

        return seats;
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


    public static ShowingShower1 getShowingShower1FromShowingEntity(ShowingEntity showing) {
        ShowingShower1 showingShower1 = new ShowingShower1();

        showingShower1.setId(showing.getId());
        showingShower1.setStartTime(ConverterUtils.convertDateTimeToString(showing.getStartTime()));
        showingShower1.setEndTime(ConverterUtils.convertDateTimeToString(showing.getEndTime()));
        showingShower1.setPriceManual(ConverterUtils.convertDoubleToString(showing.getPriceManual()));
        showingShower1.setHall(BuilderUtils.getHallShower2FromHallEntity(showing.getHall()));
        showingShower1.setFilm(BuilderUtils.getFilmShower2FromFilmEntity(showing.getFcm().getFilm()));
        showingShower1.setCinema(BuilderUtils.getCinemaShower2FromCinemaEntity(showing.getFcm().getCinema()));
        showingShower1.setSeats(BuilderUtils.getSeatShowersFromSeatEntities(showing.getSeats()));

        return showingShower1;
    }


    private static ShowingShower2 getShowingShower2FromShowingEntity(ShowingEntity showing) {
        ShowingShower2 showingShower2 = new ShowingShower2();

        showingShower2.setId(showing.getId());
        showingShower2.setHall(BuilderUtils.getHallShower2FromHallEntity(showing.getHall()));
        showingShower2.setStartTime(ConverterUtils.convertDateTimeToString(showing.getStartTime()));
        showingShower2.setEndTime(ConverterUtils.convertDateTimeToString(showing.getEndTime()));
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


    private static CinemaShower2 getCinemaShower2FromCinemaEntity(CinemaEntity cinemaEntity) {
        CinemaShower2 cinema = new CinemaShower2();

        cinema.setId(cinemaEntity.getId());
        cinema.setName(cinemaEntity.getName());
        cinema.setAddress(cinemaEntity.getAddress());
        cinema.setImageUrl(cinemaEntity.getImageUrl());

        return cinema;
    }

    public static List<CinemaShower2> getCinemaShower2sFromCinemaEntities(List<CinemaEntity> cinemaEntities) {
        List<CinemaShower2> cinemas = new ArrayList<CinemaShower2>();

        if (cinemaEntities != null) {
            for (CinemaEntity cinemaEntity: cinemaEntities) {
                cinemas.add(BuilderUtils.getCinemaShower2FromCinemaEntity(cinemaEntity));
            }
        }

        return cinemas;
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


    private static OrderItemShower getOrderItemShowerFromOrderItemEntity(OrderItemEntity orderItemEntity) {
        OrderItemShower orderItemShower = new OrderItemShower();

        orderItemShower.setId(orderItemEntity.getId());
        orderItemShower.setRow(ConverterUtils.convertShortToString(orderItemEntity.getRow()));
        orderItemShower.setColumn(ConverterUtils.convertShortToString(orderItemEntity.getColumn()));
        orderItemShower.setPrice(ConverterUtils.convertDoubleToString(orderItemEntity.getPrice()));

        return orderItemShower;
    }

    private static List<OrderItemShower> getOrderItemShowersFromOrderItemEntities(List<OrderItemEntity> orderItemEntities) {
        List<OrderItemShower> orderItems = new ArrayList<OrderItemShower>();

        if (orderItemEntities != null) {
            for (OrderItemEntity orderItem: orderItemEntities) {
                orderItems.add(BuilderUtils.getOrderItemShowerFromOrderItemEntity(orderItem));
            }
        }

        return orderItems;
    }


    private static PurchaseOrderShower getPurchaseOrderShowerFromPurchaseOrderEntity(PurchaseOrderEntity purchaseOrderEntity) {
        PurchaseOrderShower pos = new PurchaseOrderShower();

        pos.setId(purchaseOrderEntity.getId());
        pos.setFilmId(purchaseOrderEntity.getFilmId());
        pos.setFilmName(purchaseOrderEntity.getFilmName());
        pos.setCinemaId(purchaseOrderEntity.getCinemaId());
        pos.setCinemaName(purchaseOrderEntity.getCinemaName());
        pos.setHallName(purchaseOrderEntity.getHallName());
        pos.setCreateTime(ConverterUtils.convertDateTimeToString(purchaseOrderEntity.getCreateTime()));
        pos.setStartTime(ConverterUtils.convertDateTimeToString(purchaseOrderEntity.getStartTime()));
        pos.setDiscount(ConverterUtils.convertDoubleToString(purchaseOrderEntity.getDiscount()));
        pos.setStatus(purchaseOrderEntity.getStatus());
        pos.setTotalPrice(ConverterUtils.convertDoubleToString(purchaseOrderEntity.getTotalPrice()));
        pos.setOrderItems(BuilderUtils.getOrderItemShowersFromOrderItemEntities(purchaseOrderEntity.getOrderItems()));

        return pos;
    }

    public static List<PurchaseOrderShower> getPurchaseOrderShowersFromPurchaseOrderEntities(List<PurchaseOrderEntity> poes) {
        List<PurchaseOrderShower> purchaseOrders = new ArrayList<PurchaseOrderShower>();

        if (poes != null) {
            for (PurchaseOrderEntity poe: poes) {
                purchaseOrders.add(BuilderUtils.getPurchaseOrderShowerFromPurchaseOrderEntity(poe));
            }
        }

        return purchaseOrders;
    }

}
