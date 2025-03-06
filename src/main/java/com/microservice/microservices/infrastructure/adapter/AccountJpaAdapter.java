package com.microservice.microservices.infrastructure.adapter;

import com.microservice.microservices.application.interfaces.AccountServiceRepository;
import com.microservice.microservices.domain.entity.Account;
import com.microservice.microservices.infrastructure.entity.AccountEntity;
import com.microservice.microservices.infrastructure.repository.AccountRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component
public class AccountJpaAdapter implements AccountServiceRepository {

    private final AccountRepository accountRepository;

    public AccountJpaAdapter(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public Optional<Account> findById(UUID id) {
        return accountRepository.findById(id)
                .map(this::toDomain);
    }

    @Override
    public void save(Account account) {
        AccountEntity accountEntity = toEntity(account);
        accountRepository.save(accountEntity);
    }

    @Override
    public void update(Account account) {
        AccountEntity accountEntity = toEntity(account);
        accountRepository.save(accountEntity);
    }

    @Override
    public void delete(UUID id) {
        accountRepository.deleteById(id);
    }

    private AccountEntity toEntity(Account account) {
        return new AccountEntity.Builder()
                .id(account.getId())
                .bankAccountNumber(account.getBankAccountNumber())
                .accountHolder(account.getAccountHolder())
                .cvcEncrypted(account.getCvcEncrypted())
                .dueDate(account.getDueDate())
                .userID(account.getUserId())
                .balance(account.getBalance())
                .build();
    }

    private Account toDomain(AccountEntity accountEntity) {
        return new Account(
                accountEntity.getId(),
                accountEntity.getBankAccountNumber(),
                accountEntity.getAccountHolder(),
                accountEntity.getCvcEncrypted(),
                accountEntity.getDueDate(),
                accountEntity.getUserID(),
                accountEntity.getBalance()
        );
    }
}