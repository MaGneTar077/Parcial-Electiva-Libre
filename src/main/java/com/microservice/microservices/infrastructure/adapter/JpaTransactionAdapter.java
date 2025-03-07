package com.microservice.microservices.infrastructure.adapter;

import com.microservice.microservices.domain.entity.Transaction;
import com.microservice.microservices.domain.repository.TransactionRepository;
import com.microservice.microservices.infrastructure.entity.TransactionEntity;
import com.microservice.microservices.infrastructure.mapper.TransactionMapper;
import com.microservice.microservices.infrastructure.repository.SpringDataTransactionRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class JpaTransactionAdapter implements TransactionRepository {

    private final SpringDataTransactionRepository springDataTransactionRepository;

    public JpaTransactionAdapter(SpringDataTransactionRepository springDataTransactionRepository) {
        this.springDataTransactionRepository = springDataTransactionRepository;
    }

    @Override
    public Transaction save(Transaction transaction) {
        TransactionEntity entity = TransactionMapper.toEntity(transaction);
        TransactionEntity savedEntity = springDataTransactionRepository.save(entity);
        return TransactionMapper.toDomain(savedEntity);
    }

    @Override
    public List<Transaction> findAll() {
        return springDataTransactionRepository.findAll()
                .stream()
                .map(TransactionMapper::toDomain)
                .collect(Collectors.toList());
    }
}