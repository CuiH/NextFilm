package com.xx.nextfilm.entity;

import javax.persistence.*;
import java.util.List;

/**
 * Created by CuiH on 2016/5/17.
 */
@Entity(name = "hall")
public class HallEntity {

    private Long id;
    private String name;
    private String type;
    private Short rowNum;
    private Short columnNum;

    // 该hall的所属cinema，保存用
    private CinemaEntity cinema;
    // 该hall的所有排片场次，级联删除用
    private List<ShowingEntity> showings;


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
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Basic
    @Column(name = "type")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


    @Basic
    @Column(name = "row_num")
    public Short getRowNum() {
        return rowNum;
    }

    public void setRowNum(Short rowNum) {
        this.rowNum = rowNum;
    }


    @Basic
    @Column(name = "column_num")
    public Short getColumnNum() {
        return columnNum;
    }

    public void setColumnNum(Short columnNum) {
        this.columnNum = columnNum;
    }


    @ManyToOne(fetch = FetchType.LAZY, optional = false, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "cinema_id")
    public CinemaEntity getCinema() {
        return cinema;
    }

    public void setCinema(CinemaEntity cinema) {
        this.cinema = cinema;
    }


    @OneToMany(fetch = FetchType.LAZY, mappedBy = "hall", cascade = CascadeType.REMOVE)
    public List<ShowingEntity> getShowings() {
        return showings;
    }

    public void setShowings(List<ShowingEntity> showings) {
        this.showings = showings;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        HallEntity that = (HallEntity) o;

        if (id != that.id) return false;

        return true;
    }


    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));

        return result;
    }

}
