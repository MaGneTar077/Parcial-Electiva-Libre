package com.microservice.microservices.domain.entity;

import java.util.Date;

public class Transactions {
    private String id;
    private String type;
    private double amount;
    private Date date;


    public Transactions(String id, String type, double amount, Date date) {
        this.id = id;
        this.type = type;
        this.amount = amount;
        this.date = date;
    }

    public String getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public double getAmount() {
        return amount;
    }

    public Date getDate() {
        return date;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setDate(Date date) {
        this.date = date;
    }


}





