package com.microservice.microservices.domain.entity;

import java.util.Objects;
import java.util.Date;

public class Transactions {
    private final String id;
    private final String accountId;
    private final String type;
    private final double amount;
    private final Date date;

    // Constructor
    public Transactions(String id, String accountID, String type, double amount, Date date) {
        this.id = id;
        this.accountId = accountID;
        this.type = type;
        this.amount = amount;
        this.date = date;
        validate();
    }

    public String getId() {
        return id;
    }

    public String getAccountID() {
        return accountId;
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

    private void validate() {
        if (id == null || id.isBlank()) {
            throw new IllegalArgumentException("ID cannot be null or blank");
        }
        if (accountId == null || accountId.isBlank()) {
            throw new IllegalArgumentException("Account ID cannot be null or blank");
        }
        if (type == null || (!type.equals("Income") && !type.equals("Outcome"))) {
            throw new IllegalArgumentException("Type must be 'income' or 'outcome'");
        }
        if (amount < 0) {
            throw new IllegalArgumentException("Amount cannot be negative");
        }
        if (date == null) {
            throw new IllegalArgumentException("Date cannot be null");
        }
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transactions that = (Transactions) o;
        return Double.compare(that.amount, amount) == 0 &&
                Objects.equals(id, that.id) &&
                Objects.equals(accountId, that.accountId) &&
                Objects.equals(type, that.type) &&
                Objects.equals(date, that.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, accountId, type, amount, date);
    }


    @Override
    public String toString() {
        return "Transactions{" +
                "id='" + id + '\'' +
                ", accountID='" + accountId + '\'' +
                ", type='" + type + '\'' +
                ", amount=" + amount +
                ", date=" + date +
                '}';
    }
}





