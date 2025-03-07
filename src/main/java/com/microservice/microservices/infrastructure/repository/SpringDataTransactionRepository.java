package com.microservice.microservices.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.microservice.microservices.domain.entity.Transactions;
import org.springframework.stereotype.Repository;



@Repository
public interface SpringDataTransactionRepository extends JpaRepository<Transactions, String> {

}
