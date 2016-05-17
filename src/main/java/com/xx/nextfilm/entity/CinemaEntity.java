package com.xx.nextfilm.entity;

import com.xx.nextfilm.dto.HallEditor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by CuiH on 2016/5/15.
 */
@Entity(name = "cinema")
public class CinemaEntity {

    private Long id;
    private String name;
    private String cityCode;
    private String address;
    private String phone;
    private String brief;
    private String imageUrl;
    private String description;

    private List<FilmEntity> films = new ArrayList<FilmEntity>();
    private List<HallEntity> halls = new ArrayList<HallEntity>();
    private List<FCMEntity> fcms = new ArrayList<FCMEntity>();


    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Basic
    @Column(name = "city_code")
    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }


    @Basic
    @Column(name = "address")
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    @Basic
    @Column(name = "phone")
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }


    @Basic
    @Column(name = "brief")
    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }


    @Basic
    @Column(name = "image_url")
    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }


    @Basic
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String discription) {
        this.description = discription;
    }


    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "film_cinema_map",
            joinColumns = { @JoinColumn(name = "cinema_id") },
            inverseJoinColumns = { @JoinColumn(name = "film_id") })
    public List<FilmEntity> getFilms() {
        return films;
    }

    public void setFilms(List<FilmEntity> films) {
        this.films = films;
    }


    @OneToMany(fetch = FetchType.LAZY, mappedBy = "cinema", cascade = CascadeType.REMOVE)
    public List<HallEntity> getHalls() {
        return halls;
    }

    public void setHalls(List<HallEntity> halls) {
        this.halls = halls;
    }


    @OneToMany(fetch = FetchType.LAZY, mappedBy = "cinema", cascade = CascadeType.REMOVE)
    public List<FCMEntity> getFcms() {
        return fcms;
    }

    public void setFcms(List<FCMEntity> fcms) {
        this.fcms = fcms;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CinemaEntity that = (CinemaEntity) o;

        if (id != that.id) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));

        return result;
    }

}
