package com.xx.nextfilm.entity;

import javax.persistence.*;
import java.util.List;

/**
 * Created by CuiH on 2016/5/17.
 */
@Entity(name = "film_cinema_map")
public class FCMEntity {

    private Long id;

    // 查询影院详情的时候加载，在CinemaDao中
    private FilmEntity film;
    // 未使用，只是CinemaEntity中的对应项
    private CinemaEntity cinema;
    // 查询影院详情的时候加载，在CinemaDao中
    private List<ShowingEntity> showings;


    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    @ManyToOne(fetch = FetchType.LAZY, optional = false, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "film_id")
    public FilmEntity getFilm() {
        return film;
    }

    public void setFilm(FilmEntity film) {
        this.film = film;
    }


    @ManyToOne(fetch = FetchType.LAZY, optional = false, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "cinema_id")
    public CinemaEntity getCinema() {
        return cinema;
    }

    public void setCinema(CinemaEntity cinema) {
        this.cinema = cinema;
    }


    @OneToMany(fetch = FetchType.LAZY, mappedBy = "fcm", cascade = CascadeType.REMOVE)
    public List<ShowingEntity> getShowings() {
        return showings;
    }

    public void setShowings(List<ShowingEntity> showings) {
        this.showings = showings;
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
