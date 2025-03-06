package com.microservice.microservices.application.service;

import com.microservice.microservices.domain.entity.Account;
import com.microservice.microservices.application.interfaces.AccountServiceRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class AccountService {
    private final AccountServiceRepository accountRepository;

    public AccountService(AccountServiceRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public Account createAccount(Account account) {
        accountRepository.save(account);
        return account;
    }

    public Optional<Account> getAccountById(UUID id) {
        return accountRepository.findById(id);
    }

    public boolean deposit(UUID id, double amount) {
        Optional<Account> accountOptional = accountRepository.findById(id);
        if (accountOptional.isPresent()) {
            Account account = accountOptional.get();
            Account updateAccount = new Account(
                    account.getId(),
                    account.getBankAccountNumber(),
                    account.getAccountHolder(),
                    account.getCvcEncrypted(),
                    account.getDueDate(),
                    account.getUserId(),
                    account.getBalance() + amount
                    //Cuando se cree transactions agregar account.getTransactions()
            );
            accountRepository.update(updateAccount);
            return true;
        }
        return false;
    }

    public boolean withdraw(UUID id, double amount) {
        Optional<Account> accountOptional = accountRepository.findById(id);
        if (accountOptional.isPresent()) {
            Account account = accountOptional.get();
            if (account.getBalance() >= amount) {
                Account updateAccount = new Account(
                        account.getId(),
                        account.getBankAccountNumber(),
                        account.getAccountHolder(),
                        account.getCvcEncrypted(),
                        account.getDueDate(),
                        account.getUserId(),
                        account.getBalance() - amount
                        //Cuando se cree transactions agregar account.getTransactions()
                );
                accountRepository.update(updateAccount);
                return true;
            }
        }
        return false;
    }

    public void delete(UUID id) {
        accountRepository.delete(id);
    }
}