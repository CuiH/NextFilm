package com.xx.nextfilm.dto;

import java.util.List;

/**
 * Created by CuiH on 2016/5/18.
 *
 * 用于影院详情页面（放在cinema的fcm中）
 */
public class FilmShower2 {

    private Long id;

    private String name;
    private String brief;
    private String language;
    private String imageUrl;


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


    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }


    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

}
