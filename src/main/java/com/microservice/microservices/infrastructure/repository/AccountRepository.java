package com.microservice.microservices.infrastructure.repository;

import com.microservice.microservices.infrastructure.entity.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
import java.util.UUID;

public interface AccountRepository extends JpaRepository<AccountEntity, UUID> {
    Optional<AccountEntity>findByBankAccountNumber(String bankAccountNumber);
}