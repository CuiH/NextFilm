package com.xx.nextfilm.dto.shower;

import java.util.List;

/**
 * Created by CuiH on 2016/5/29.
 *
 * 用于影院列表页面
 */
public class CinemaShower3 {

    private Long id;

    private String name;
    private String address;
    private String brief;
    private String imageUrl;

    private List<FilmShower3> films;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }


    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }


    public List<FilmShower3> getFilms() {
        return films;
    }

    public void setFilms(List<FilmShower3> films) {
        this.films = films;
    }
    
}
