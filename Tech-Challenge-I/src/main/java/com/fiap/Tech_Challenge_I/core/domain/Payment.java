package com.fiap.Tech_Challenge_I.core.domain;

import java.util.Date;

public class Payment {
    private Integer id;
    private Date paymentDate;
    private Boolean CheckPayment;

    public Payment() {
    }

    public Payment(Integer id, Date paymentDate, Boolean checkPayment) {
        this.id = id;
        this.paymentDate = paymentDate;
        CheckPayment = checkPayment;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    public Boolean getCheckPayment() {
        return CheckPayment;
    }

    public void setCheckPayment(Boolean checkPayment) {
        CheckPayment = checkPayment;
    }
}
