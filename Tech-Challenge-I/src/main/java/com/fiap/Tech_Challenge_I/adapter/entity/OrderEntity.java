package com.fiap.Tech_Challenge_I.adapter.entity;

import com.fiap.Tech_Challenge_I.adapter.coverter.ProductConverter;
import com.fiap.Tech_Challenge_I.adapter.coverter.UserConverter;
import com.fiap.Tech_Challenge_I.core.domain.Order;
import com.fiap.Tech_Challenge_I.core.domain.OrderStatus.*;
import com.fiap.Tech_Challenge_I.core.domain.OrderStatusEnum;
import com.fiap.Tech_Challenge_I.core.domain.Product;
import com.fiap.Tech_Challenge_I.core.domain.User;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
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

    private LocalDateTime startDate;
    private LocalDateTime endDate;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "order_product",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    private List<ProductEntity> products;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE) //User podera ter N Orders e cada Order pode ter apenas 1 User
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity user;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "payment_id", referencedColumnName = "idPayment")
    private PaymentEntity payment;

    private BigDecimal totalValue;

    public OrderEntity() {
    }

    public OrderEntity(int idOrder, IOrderStatus orderStatus, LocalDateTime startDate, LocalDateTime endDate) {
        this.idOrder = idOrder;
        this.orderStatus = convertStatusToType(orderStatus);
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public OrderEntity(int idOrder, IOrderStatus orderStatus, LocalDateTime startDate, List<Product> products, User user, BigDecimal totalValue ) {
        this.idOrder = idOrder;
        this.orderStatus = convertStatusToType(orderStatus);
        this.startDate = startDate;
        this.endDate = null;
        this.products = products.stream().map(ProductConverter::productToProductEntity).toList();
        this.user = UserConverter.userToUserEntity(user);
        this.totalValue = totalValue;
    }

    public OrderEntity(IOrderStatus orderStatus, LocalDateTime startDate, LocalDateTime endDate, List<ProductEntity> products) {
        this.orderStatus = convertStatusToType(orderStatus);
        this.startDate = startDate;
        this.endDate = endDate;
        this.products = products;
    }

    public OrderEntity(int idOrder, OrderStatusEnum orderStatus, LocalDateTime startDate, LocalDateTime endDate, List<ProductEntity> products, UserEntity user) {
        this.idOrder = idOrder;
        this.orderStatus = orderStatus;
        this.startDate = startDate;
        this.endDate = endDate;
        this.products = products;
        this.user = user;
    }

    public void setOrderStatus(OrderStatusEnum orderStatus) {
        this.orderStatus = orderStatus;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public PaymentEntity getPayment() {
        return payment;
    }

    public void setPayment(PaymentEntity payment) {
        this.payment = payment;
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

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public BigDecimal getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(BigDecimal totalValue) {
        this.totalValue = totalValue;
    }
}
