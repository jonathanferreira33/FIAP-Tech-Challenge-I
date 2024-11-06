package com.fiap.Tech_Challenge_I.core.domain;

import java.util.Date;

public record Delivery(
        int idDelivery,
        String note,
        Date startDate,
        Date endDate,
        Address address,
        DeliveryTypeEnum deliveryType
) {
}

/*
public class Delivery {
    private int idDelivery;
    private String note;
    private Date startDate;
    private Date endDate;
    private Address address;
    private DeliveryTypeEnum deliveryType;

    public Delivery() {
    }

    public Delivery(int idDelivery, String note, Date startDate, Date endDate, Address address, DeliveryTypeEnum deliveryType) {
        this.idDelivery = idDelivery;
        this.note = note;
        this.startDate = startDate;
        this.endDate = endDate;
        this.address = address;
        this.deliveryType = deliveryType;
    }

    public int getIdDelivery() {
        return idDelivery;
    }

    public void setIdDelivery(int idDelivery) {
        this.idDelivery = idDelivery;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public DeliveryTypeEnum getDeliveryType() {
        return deliveryType;
    }

    public void setDeliveryType(DeliveryTypeEnum deliveryType) {
        this.deliveryType = deliveryType;
    }
}
 */