package com.microservice.microservices.domain.repository;

import com.microservice.microservices.domain.entity.Transaction;
import java.util.List;

public interface TransactionRepository {
    Transaction save(Transaction transaction);
    List<Transaction> findAll();
}