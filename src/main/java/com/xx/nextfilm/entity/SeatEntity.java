package com.xx.nextfilm.entity;

import javax.persistence.*;

/**
 * Created by CuiH on 2016/5/17.
 */
@Entity(name = "seat")
public class SeatEntity {

    private Long id;
    private Short rowPos;
    private Short columnPos;
    // 1-未售，0-已售
    private String status;

    private ShowingEntity showing;


    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    @Basic
    @Column(name = "row_pos")
    public Short getRowPos() {
        return rowPos;
    }

    public void setRowPos(Short rowPos) {
        this.rowPos = rowPos;
    }


    @Basic
    @Column(name = "column_pos")
    public Short getColumnPos() {
        return columnPos;
    }

    public void setColumnPos(Short columnPos) {
        this.columnPos = columnPos;
    }


    @Basic
    @Column(name = "status")
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    @ManyToOne(fetch = FetchType.LAZY, optional = false, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "showing_id")
    public ShowingEntity getShowing() {
        return showing;
    }

    public void setShowing(ShowingEntity showing) {
        this.showing = showing;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SeatEntity that = (SeatEntity) o;

        if (id != that.id) return false;

        return true;
    }


    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));

        return result;
    }

}
