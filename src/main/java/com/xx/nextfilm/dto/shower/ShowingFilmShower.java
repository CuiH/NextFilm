package com.xx.nextfilm.dto.shower;

/**
 * Created by CuiH on 2016/5/23.
 */
public class ShowingFilmShower {

    private Long id;
    private String name;
    private boolean selected;


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


    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }
}
