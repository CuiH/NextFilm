package com.xx.nextfilm.entity;

import javax.persistence.*;
import java.util.List;

/**
 * Created by CuiH on 2016/5/17.
 */
@Entity(name = "film_cinema_map")
public class FCMEntity {

    private Long id;

    private FilmEntity film;

    private List<ShowingEntity> showings;

    private CinemaEntity cinema;


    @Id
    @Column(name = "id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "film_id")
    public FilmEntity getFilm() {
        return film;
    }

    public void setFilm(FilmEntity film) {
        this.film = film;
    }


    @OneToMany(fetch = FetchType.EAGER, mappedBy = "fcm")
    public List<ShowingEntity> getShowings() {
        return showings;
    }

    public void setShowings(List<ShowingEntity> showings) {
        this.showings = showings;
    }


    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "cinema_id")
    public CinemaEntity getCinema() {
        return cinema;
    }

    public void setCinema(CinemaEntity cinema) {
        this.cinema = cinema;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FCMEntity fcmEntity = (FCMEntity) o;

        if (id != fcmEntity.id) return false;

        return true;
    }


    @Override
    public int hashCode() {
        return (int) (id ^ (id >>> 32));
    }

}
