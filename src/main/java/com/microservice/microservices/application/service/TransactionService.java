package com.microservice.microservices.application.service;

import com.microservice.microservices.domain.entity.Transactions;
import com.microservice.microservices.domain.repository.TransactionRepository;
import com.microservice.microservices.application.service.NotificationSevice;

import java.util.List;

public class TransactionService {

    private final TransactionRepository transactionRepository;
    private final NotificationSevice notificationSevice;

    public TransactionService(TransactionRepository transactionRepository, NotificationSevice notificationSevice){
        this.transactionRepository = transactionRepository;
        this.notificationSevice = notificationSevice;
    }

    public Transactions createTransaction(Transactions transactions){

        Transactions savedTransaction = transactionRepository.save(transactions);

        notificationSevice.notify(savedTransaction);
        return savedTransaction;
    }

    public List<Transactions> getAllTransactions() {
        return transactionRepository.findAll();
    }
}
