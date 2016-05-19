package com.xx.nextfilm.dto;

import java.util.List;

/**
 * Created by CuiH on 2016/5/18.
 *
 * 用于影院详情页面
 */
public class CinemaShower1 {

    private Long id;

    private String name;
    private String address;
    private String phone;
    private String brief;
    private String imageUrl;
    private String description;

    private List<HallShower1> halls;
    private List<FCMShower1> fcms;


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


    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public List<HallShower1> getHalls() {
        return halls;
    }

    public void setHalls(List<HallShower1> halls) {
        this.halls = halls;
    }


    public List<FCMShower1> getFcms() {
        return fcms;
    }

    public void setFcms(List<FCMShower1> fcms) {
        this.fcms = fcms;
    }

}
