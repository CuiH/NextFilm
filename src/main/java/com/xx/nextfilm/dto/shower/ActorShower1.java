package com.xx.nextfilm.dto.shower;

/**
 * Created by CuiH on 2016/5/18.
 *
 * 用于演员详情页面
 */
public class ActorShower1 {

    private Long id;

    private String name;
    private String imageUrl;
    private String brief;
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
