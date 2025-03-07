package com.microservice.microservices.domain.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Account {
    private UUID id;
    private String bankAccountNumber;
    private String accountHolder;
    private String cvcEncrypted;
    private String dueDate;
    private UUID userId;
    private double balance;
    private List<Transaction> transactions; // Lista de transacciones

    public Account(UUID id, String bankAccountNumber, String accountHolder, String cvcEncrypted, String dueDate, UUID userId, double balance) {
        this.id = id;
        this.bankAccountNumber = bankAccountNumber;
        this.accountHolder = accountHolder;
        this.cvcEncrypted = cvcEncrypted;
        this.dueDate = dueDate;
        this.userId = userId;
        this.balance = balance;
        this.transactions = new ArrayList<>();
    }

    public UUID getId() { return id; }
    public String getBankAccountNumber() { return bankAccountNumber; }
    public String getAccountHolder() { return accountHolder; }
    public String getCvcEncrypted() { return cvcEncrypted; }
    public String getDueDate() { return dueDate; }
    public UUID getUserId() { return userId; }
    public double getBalance() { return balance; }
    public List<Transaction> getTransactions() { return transactions; }


    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void addTransaction(Transaction transaction) {
        this.transactions.add(transaction);
    }
}