package com.microservice.microservices.domain.repository;

import com.microservice.microservices.domain.entity.Transactions;
import java.util.List;


public interface TransactionRepository {
    Transactions save (Transactions transactions);
    List<Transactions> findByAccountId(String accountId);
}
