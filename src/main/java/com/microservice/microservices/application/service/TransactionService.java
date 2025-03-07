package com.microservice.microservices.application.service;

import com.microservice.microservices.domain.entity.Transactions;
import com.microservice.microservices.domain.repository.TransactionRepository;
import com.microservice.microservices.domain.valueObject.TransactionType;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService {

    private final TransactionRepository transactionRepository;


    public TransactionService(TransactionRepository transactionRepository, NotificationSevice notificationSevice){
        this.transactionRepository = transactionRepository;
    }

    public Transactions processTransaction(Transactions transaction) {

        if (TransactionType.income.name().equals(transaction.getType())) {
            System.out.println("Procesando transacción de ingreso...");
        } else if (TransactionType.outcome.name().equals(transaction.getType())) {
            System.out.println("Procesando transacción de egreso...");
        }

        return transactionRepository.save(transaction);
    }
    public List<Transactions> getAllTransactions() {
        return transactionRepository.findAll();
    }

    public Transactions saveTransaction(Transactions transaction){
        return transactionRepository.save(transaction);
    }
}
