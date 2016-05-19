package com.xx.nextfilm.dto;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.DecimalMin;

/**
 * Created by CuiH on 2016/5/17.
 */
public class HallEditor {

    private Long id;

    @NotEmpty
    private String name;
    @NotEmpty
    private String type;
    @DecimalMin("0")
    private String rowNum;
    @DecimalMin("0")
    private String columnNum;

    private Long cinemaId;


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


    public String getRowNum() {
        return rowNum;
    }

    public void setRowNum(String rowNum) {
        this.rowNum = rowNum;
    }


    public String getColumnNum() {
        return columnNum;
    }

    public void setColumnNum(String columnNum) {
        this.columnNum = columnNum;
    }


    public Long getCinemaId() {
        return cinemaId;
    }

    public void setCinemaId(Long cinemaId) {
        this.cinemaId = cinemaId;
    }

}
