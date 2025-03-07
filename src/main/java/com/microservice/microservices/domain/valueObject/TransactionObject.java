package com.microservice.microservices.domain.valueObject;

import com.microservice.microservices.domain.entity.Transactions;
import java.util.Objects;
import java.util.Date;

public class TransactionObject extends Transactions {

    public TransactionObject(String id, String type, double amount, Date date) {
        super(id, type, amount, date);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TransactionObject that = (TransactionObject) o;
        return Double.compare(that.getAmount(), this.getAmount()) == 0 &&
                Objects.equals(that.getId(), this.getId()) &&
                Objects.equals(that.getType(), this.getType()) &&
                Objects.equals(that.getDate(), this.getDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getId(), this.getType(), this.getAmount(), this.getDate());
    }

    @Override
    public String toString() {
        return "TransactionObject{" +
                "id='" + this.getId() + '\'' +
                ", type='" + this.getType() + '\'' +
                ", amount=" + this.getAmount() +
                ", date=" + this.getDate() +
                '}';
    }
}