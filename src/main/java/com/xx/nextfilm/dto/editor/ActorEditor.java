package com.xx.nextfilm.dto.editor;

import org.hibernate.validator.constraints.NotEmpty;

import java.util.Date;

/**
 * Created by CuiH on 2016/5/15.
 */
public class ActorEditor {

    private Long id;

    @NotEmpty
    private String name;
    @NotEmpty
    private String imageUrl;
    @NotEmpty
    private String brief;
    @NotEmpty
    private String birthday;


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


    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }


    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }


    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

}
