package com.fiap.Tech_Challenge_I.adapter.entity;

import com.fiap.Tech_Challenge_I.core.domain.OrderStatusEnum;
import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "TCDB_ORDER")
public class OrderEntity {
    @Id
    @GeneratedValue
    private int idOrder;

    private OrderStatusEnum orderStatus;
    private Date startDate;
    private Date endDate;

    @ManyToMany
    @JoinTable(
            name = "order_product",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    private List<ProductEntity> products;

    public OrderEntity() {
    }

    public OrderEntity(int idOrder, OrderStatusEnum orderStatus, Date startDate, Date endDate) {
        this.idOrder = idOrder;
        this.orderStatus = orderStatus;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public OrderEntity(int idOrder, OrderStatusEnum orderStatus, Date startDate, Date endDate, List<ProductEntity> products) {
        this.idOrder = idOrder;
        this.orderStatus = orderStatus;
        this.startDate = startDate;
        this.endDate = endDate;
        this.products = products;
    }

    public OrderEntity(OrderStatusEnum orderStatus, Date startDate, Date endDate, List<ProductEntity> products) {
        this.orderStatus = orderStatus;
        this.startDate = startDate;
        this.endDate = endDate;
        this.products = products;
    }

    public List<ProductEntity> getProducts() {
        return products;
    }

    public void setProducts(List<ProductEntity> products) {
        this.products = products;
    }

    public int getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(int idOrder) {
        this.idOrder = idOrder;
    }

    public OrderStatusEnum getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatusEnum orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}
