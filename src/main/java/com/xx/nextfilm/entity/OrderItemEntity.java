package com.xx.nextfilm.entity;

import javax.persistence.*;

/**
 * Created by cuihao on 2016/5/27.
 */
@Entity(name = "order_item")
public class OrderItemEntity {

    private Long id;
    private Double price;
    private Short row;
    private Short column;

    // 对应项，未使用
    private PurchaseOrderEntity purchaseOrder;


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
    @Column(name = "price")
    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }


    @Basic
    @Column(name = "row_pos")
    public Short getRow() {
        return row;
    }

    public void setRow(Short row) {
        this.row = row;
    }


    @Basic
    @Column(name = "column_pos")
    public Short getColumn() {
        return column;
    }

    public void setColumn(Short column) {
        this.column = column;
    }


    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "purchase_id")
    public PurchaseOrderEntity getPurchaseOrder() {
        return purchaseOrder;
    }

    public void setPurchaseOrder(PurchaseOrderEntity purchaseOrder) {
        this.purchaseOrder = purchaseOrder;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrderItemEntity that = (OrderItemEntity) o;

        if (id != that.id) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));

        return result;
    }

}
