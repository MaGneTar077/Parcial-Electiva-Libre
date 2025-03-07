package com.microservice.microservices.infrastructure.mapper;

import com.microservice.microservices.domain.entity.Transaction;
import com.microservice.microservices.infrastructure.entity.TransactionEntity;

public class TransactionMapper {

    public static TransactionEntity toEntity(Transaction transaction) {
        return new TransactionEntity(
                transaction.getId(),
                transaction.getType(),
                transaction.getAmount(),
                transaction.getDate()
        );
    }

    public static Transaction toDomain(TransactionEntity transactionEntity) {
        return new Transaction(
                transactionEntity.getId(),
                transactionEntity.getType(),
                transactionEntity.getAmount(),
                transactionEntity.getDate()
        );
    }
}