package com.xx.nextfilm.dto.shower;

import java.util.List;

/**
 * Created by cuihao on 2016/5/28.
 *
 * 用于影院列表页面
 */
public class FilmShower4 {

    private Long id;
    private String name;
    private String brief;
    private String onDate;
    private String imageUrl;
    private String category;

    private List<ActorShower3> actors;
    private List<ActorShower3> directors;


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


    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }


    public String getOnDate() {
        return onDate;
    }

    public void setOnDate(String onDate) {
        this.onDate = onDate;
    }


    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }


    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }


    public List<ActorShower3> getActors() {
        return actors;
    }

    public void setActors(List<ActorShower3> actors) {
        this.actors = actors;
    }


    public List<ActorShower3> getDirectors() {
        return directors;
    }

    public void setDirectors(List<ActorShower3> directors) {
        this.directors = directors;
    }

}
