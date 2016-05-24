package com.xx.nextfilm.dto;

/**
 * Created by CuiH on 2016/5/18.
 *
 * 用于影院详情页面（放在cinema的fcm的showing中）
 */
public class HallShower {

    private Long id;

    private String name;
    private String type;


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


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
