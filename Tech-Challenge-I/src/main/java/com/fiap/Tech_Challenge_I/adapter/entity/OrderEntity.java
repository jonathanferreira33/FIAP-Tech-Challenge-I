package com.fiap.Tech_Challenge_I.adapter.entity;

import com.fiap.Tech_Challenge_I.adapter.coverter.ProductConverter;
import com.fiap.Tech_Challenge_I.adapter.coverter.UserConverter;
import com.fiap.Tech_Challenge_I.core.domain.Order;
import com.fiap.Tech_Challenge_I.core.domain.OrderStatus.*;
import com.fiap.Tech_Challenge_I.core.domain.OrderStatusEnum;
import com.fiap.Tech_Challenge_I.core.domain.Product;
import com.fiap.Tech_Challenge_I.core.domain.User;
import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

import static com.fiap.Tech_Challenge_I.core.domain.DeliveryTypeEnum.*;

@Entity
@Table(name = "TCDB_ORDER")
public class OrderEntity {
    @Id
    @GeneratedValue
    private int idOrder;

    @Enumerated(EnumType.STRING)
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

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity user;

    public OrderEntity() {
    }

    public OrderEntity(int idOrder, IOrderStatus orderStatus, Date startDate, Date endDate) {
        this.idOrder = idOrder;
        this.orderStatus = convertStatusToType(orderStatus);
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public OrderEntity(int idOrder, IOrderStatus orderStatus, Date startDate, List<Product> products, User user ) {
        this.idOrder = idOrder;
        this.orderStatus = convertStatusToType(orderStatus);
        this.startDate = startDate;
        this.endDate = null;
        this.products = products.stream().map(ProductConverter::productToProductEntity).toList();
        this.user = UserConverter.userToUserEntity(user);
    }

    public OrderEntity(IOrderStatus orderStatus, Date startDate, Date endDate, List<ProductEntity> products) {
        this.orderStatus = convertStatusToType(orderStatus);
        this.startDate = startDate;
        this.endDate = endDate;
        this.products = products;
    }

    public OrderEntity(int idOrder, OrderStatusEnum orderStatus, Date startDate, Date endDate, List<ProductEntity> products, UserEntity user) {
        this.idOrder = idOrder;
        this.orderStatus = orderStatus;
        this.startDate = startDate;
        this.endDate = endDate;
        this.products = products;
        this.user = user;
    }

    private OrderStatusEnum convertStatusToType(IOrderStatus orderStatus) {
        if (orderStatus instanceof Incoming) return OrderStatusEnum.incoming;
        if (orderStatus instanceof Ready) return OrderStatusEnum.ready;
        if (orderStatus instanceof Verification) return OrderStatusEnum.verification;
        if (orderStatus instanceof Delivery) return OrderStatusEnum.delivered;
        if (orderStatus instanceof Completed) return OrderStatusEnum.completed;
        throw new IllegalArgumentException("Tipo de status de pedido desconhecido");
    }

    private IOrderStatus convertTypeToStatus(OrderStatusEnum type) {
        switch (type) {
            case incoming: return new Incoming();
            case ready: return new Ready();
            case verification: return new Verification();
            case delivered: return new Delivery();
            case completed: return new Completed();
            default: throw new IllegalArgumentException("Tipo de status de pedido desconhecido");
        }
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

    public IOrderStatus getOrderStatus() {
        return convertTypeToStatus(orderStatus);
    }

    public void setOrderStatus(IOrderStatus orderStatus) {
        this.orderStatus = convertStatusToType(orderStatus);
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
