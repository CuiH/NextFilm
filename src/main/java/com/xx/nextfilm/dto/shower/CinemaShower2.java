package com.xx.nextfilm.dto.shower;

/**
 * Created by CuiH on 2016/5/18.
 *
 * 用于编辑
 */
public class CinemaShower2 {

    private Long id;

    private String name;
    private String address;
    private String imageUrl;


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


    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
