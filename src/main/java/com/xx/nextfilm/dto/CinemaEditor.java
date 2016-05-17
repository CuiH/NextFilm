package com.xx.nextfilm.dto;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * Created by CuiH on 2016/5/16.
 */
public class CinemaEditor {

    private Long id;

    @NotEmpty
    private String name;
    @NotEmpty
    private String city;
    @NotEmpty
    private String address;
    @NotEmpty
    private String phone;
    @NotEmpty
    private String brief;
    @NotEmpty
    private String imageUrl;
    @NotEmpty
    private String description;


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


    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
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

}
