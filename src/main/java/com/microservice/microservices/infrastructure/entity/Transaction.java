package com.microservice.microservices.infrastructure.entity;

import com.microservice.microservices.domain.valueObject.TransactionType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Enumerated;
import jakarta.persistence.EnumType;
import java.util.Date;

@Entity
public class Transaction {

    @Id
    private String id;

    @Enumerated(EnumType.STRING)
    private TransactionType type;

    private double amount;
    private Date date;


    public Transaction(String id, TransactionType type, double amount, Date date) {
        this.id = id;
        this.type = type;
        this.amount = amount;
        this.date = date;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public TransactionType getType() {
        return type;
    }

    public void setType(TransactionType type) {
        this.type = type;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}