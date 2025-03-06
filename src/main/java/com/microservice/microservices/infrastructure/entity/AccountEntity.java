package com.microservice.microservices.infrastructure.entity;

import jakarta.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "account")
public class AccountEntity {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(name = "bank_account_number", nullable = false, unique = true)
    private String bankAccountNumber;

    @Column(name = "account_holder", nullable = false)
    private String accountHolder;

    @Column(name = "cvc_encrypted", nullable = false)
    private String cvcEncrypted;

    @Column(name = "due_date", nullable = false)
    private String dueDate;

    @Column(name = "user_id", nullable = false)
    private UUID userID;

    @Column(name = "balance", nullable = false)
    private double balance;


    private AccountEntity(Builder builder) {
        this.id = builder.id;
        this.bankAccountNumber = builder.bankAccountNumber;
        this.accountHolder = builder.accountHolder;
        this.cvcEncrypted = builder.cvcEncrypted;
        this.dueDate = builder.dueDate;
        this.userID = builder.userID;
        this.balance = builder.balance;
    }

    public UUID getId() { return id; }
    public String getBankAccountNumber() { return bankAccountNumber; }
    public String getAccountHolder() { return accountHolder; }
    public String getCvcEncrypted() { return cvcEncrypted; }
    public String getDueDate() { return dueDate; }
    public UUID getUserID() { return userID; }
    public double getBalance() { return balance; }


    public static class Builder {
        private UUID id;
        private String bankAccountNumber;
        private String accountHolder;
        private String cvcEncrypted;
        private String dueDate;
        private UUID userID;
        private double balance;

        public Builder id(UUID id) {
            this.id = id;
            return this;
        }

        public Builder bankAccountNumber(String bankAccountNumber) {
            this.bankAccountNumber = bankAccountNumber;
            return this;
        }

        public Builder accountHolder(String accountHolder) {
            this.accountHolder = accountHolder;
            return this;
        }

        public Builder cvcEncrypted(String cvcEncrypted) {
            this.cvcEncrypted = cvcEncrypted;
            return this;
        }

        public Builder dueDate(String dueDate) {
            this.dueDate = dueDate;
            return this;
        }

        public Builder userID(UUID userID) {
            this.userID = userID;
            return this;
        }

        public Builder balance(double balance) {
            this.balance = balance;
            return this;
        }

        public AccountEntity build() {
            return new AccountEntity(this);
        }
    }
}