package com.microservice.microservices.infrastructure.adapter;

import com.microservice.microservices.domain.entity.Transactions;
import com.microservice.microservices.domain.repository.TransactionRepository;
import com.microservice.microservices.infrastructure.repository.SpringDataTransactionRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class JpaTransactionAdapter implements TransactionRepository {

    private final SpringDataTransactionRepository springDataTransactionRepository;


    public JpaTransactionAdapter(SpringDataTransactionRepository springDataTransactionRepository) {
        this.springDataTransactionRepository = springDataTransactionRepository;
    }

    @Override
    public Transactions save(Transactions transaction) {
        return springDataTransactionRepository.save(transaction);
    }

    @Override
    public List<Transactions> findAll() {
        return springDataTransactionRepository.findAll();
    }
}