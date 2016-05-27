package com.xx.nextfilm.entity;

import javax.persistence.*;

/**
 * Created by cuihao on 2016/5/27.
 */
@Entity
@Table(name = "order_item", schema = "nextfilm", catalog = "")
public class OrderItemEntity {
    private long id;
    private Double price;
    private Short row;
    private Short column;

    @Id
    @Column(name = "id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "price")
    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Basic
    @Column(name = "row")
    public Short getRow() {
        return row;
    }

    public void setRow(Short row) {
        this.row = row;
    }

    @Basic
    @Column(name = "column")
    public Short getColumn() {
        return column;
    }

    public void setColumn(Short column) {
        this.column = column;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrderItemEntity that = (OrderItemEntity) o;

        if (id != that.id) return false;
        if (price != null ? !price.equals(that.price) : that.price != null) return false;
        if (row != null ? !row.equals(that.row) : that.row != null) return false;
        if (column != null ? !column.equals(that.column) : that.column != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (row != null ? row.hashCode() : 0);
        result = 31 * result + (column != null ? column.hashCode() : 0);
        return result;
    }
}
