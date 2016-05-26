package com.xx.nextfilm.dto.shower;

/**
 * Created by CuiH on 2016/5/18.
 *
 * 用于随电影简介显示（放在film中）
 */
public class ActorShower2 {

    private Long id;

    private String name;
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


    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

}
