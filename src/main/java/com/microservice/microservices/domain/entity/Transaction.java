package com.microservice.microservices.domain.entity;

import com.microservice.microservices.domain.valueObject.TransactionType;
import java.util.Date;

public class Transaction {
    private String id;
    private TransactionType type;
    private double amount;
    private Date date;

    public Transaction(String id, TransactionType type, double amount, Date date) {
        this.id = id;
        this.type = type;
        this.amount = amount;
        this.date = date;
    }

    // Getters y setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public TransactionType getType() { return type; }
    public void setType(TransactionType type) { this.type = type; }
    public double getAmount() { return amount; }
    public void setAmount(double amount) { this.amount = amount; }
    public Date getDate() { return date; }
    public void setDate(Date date) { this.date = date; }
}