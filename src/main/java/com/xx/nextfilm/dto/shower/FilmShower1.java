package com.xx.nextfilm.dto.shower;

import com.xx.nextfilm.dto.shower.ActorShower2;

import java.util.List;

/**
 * Created by CuiH on 2016/5/18.
 *
 * 用于影片详情页面
 */
public class FilmShower1 {

    private Long id;

    private String name;
    private String alias;
    private String brief;
    private String language;
    private String length;
    private String onDate;
    private String imageUrl;
    private String category;
    private String type;

    private List<ActorShower2> actors;
    private List<ActorShower2> directors;


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


    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }


    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }


    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }


    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
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


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


    public List<ActorShower2> getActors() {
        return actors;
    }

    public void setActors(List<ActorShower2> actors) {
        this.actors = actors;
    }


    public List<ActorShower2> getDirectors() {
        return directors;
    }

    public void setDirectors(List<ActorShower2> directors) {
        this.directors = directors;
    }

}
