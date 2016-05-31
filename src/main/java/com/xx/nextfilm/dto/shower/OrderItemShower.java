package com.xx.nextfilm.dto.shower;

/**
 * Created by cuihao on 2016/5/28.
 *
 */
public class OrderItemShower {

    private Long id;
    private String price;
    private String row;
    private String column;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }


    public String getRow() {
        return row;
    }

    public void setRow(String row) {
        this.row = row;
    }


    public String getColumn() {
        return column;
    }

    public void setColumn(String column) {
        this.column = column;
    }

}
