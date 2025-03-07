package com.microservice.microservices.application.service;

import com.microservice.microservices.domain.entity.Transaction;
import com.microservice.microservices.domain.repository.TransactionRepository;
import com.microservice.microservices.domain.valueObject.TransactionType;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService {

    private final TransactionRepository transactionRepository;

    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public Transaction processTransaction(Transaction transaction) {
        if (TransactionType.INCOME.equals(transaction.getType())) {
            System.out.println("Procesando transacción de ingreso...");
        } else if (TransactionType.OUTCOME.equals(transaction.getType())) {
            System.out.println("Procesando transacción de egreso...");
        }

        return transactionRepository.save(transaction);
    }

    public List<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }

    public Transaction saveTransaction(Transaction transaction) {
        return transactionRepository.save(transaction);
    }
}