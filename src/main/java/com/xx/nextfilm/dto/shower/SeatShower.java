package com.xx.nextfilm.dto.shower;

/**
 * Created by CuiH on 2016/5/18.
 *
 * 用于场次详情页面（放在showing中）
 */
public class SeatShower {

    private Long id;

    private Short rowPos;
    private Short columnPos;
    // 1-未售，0-已售
    private String status;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public Short getRowPos() {
        return rowPos;
    }

    public void setRowPos(Short rowPos) {
        this.rowPos = rowPos;
    }


    public Short getColumnPos() {
        return columnPos;
    }

    public void setColumnPos(Short columnPos) {
        this.columnPos = columnPos;
    }


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
