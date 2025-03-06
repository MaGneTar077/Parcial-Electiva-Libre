package com.microservice.microservices.application.interfaces;

import com.microservice.microservices.domain.entity.Account;
import java.util.Optional;
import java.util.UUID;

public interface AccountServiceRepository { //Port
    Optional<Account> findById(UUID id);
    void save(Account account);
    void update(Account account);
    void delete(UUID id);
}