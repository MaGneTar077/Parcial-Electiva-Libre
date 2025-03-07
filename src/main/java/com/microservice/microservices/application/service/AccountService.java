package com.microservice.microservices.application.service;

import com.microservice.microservices.domain.entity.Account;
import com.microservice.microservices.domain.entity.Transaction;
import com.microservice.microservices.application.interfaces.AccountServiceRepository;
import com.microservice.microservices.domain.valueObject.TransactionType; // Importar el enum
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;
import java.util.UUID;

@Service
public class AccountService {
    private final AccountServiceRepository accountRepository;
    private final TransactionService transactionService;

    public AccountService(AccountServiceRepository accountRepository, TransactionService transactionService) {
        this.accountRepository = accountRepository;
        this.transactionService = transactionService;
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
            account.setBalance(account.getBalance() + amount);

            // Usar el enum TransactionType.INCOME para depósitos
            Transaction depositTransaction = new Transaction(
                    UUID.randomUUID().toString(),
                    TransactionType.INCOME, // Usar el enum
                    amount,
                    new Date()
            );
            account.addTransaction(depositTransaction);
            transactionService.saveTransaction(depositTransaction);

            accountRepository.update(account);
            return true;
        }
        return false;
    }

    public boolean withdraw(UUID id, double amount) {
        Optional<Account> accountOptional = accountRepository.findById(id);
        if (accountOptional.isPresent()) {
            Account account = accountOptional.get();
            if (account.getBalance() >= amount) {
                account.setBalance(account.getBalance() - amount);

                // Usar el enum TransactionType.OUTCOME para retiros
                Transaction withdrawalTransaction = new Transaction(
                        UUID.randomUUID().toString(),
                        TransactionType.OUTCOME, // Usar el enum
                        amount,
                        new Date()
                );
                account.addTransaction(withdrawalTransaction);
                transactionService.saveTransaction(withdrawalTransaction);

                accountRepository.update(account);
                return true;
            }
        }
        return false;
    }

    public boolean transfer(UUID fromAccountId, UUID toAccountId, double amount) {
        Optional<Account> fromAccountOptional = accountRepository.findById(fromAccountId);
        Optional<Account> toAccountOptional = accountRepository.findById(toAccountId);

        if (fromAccountOptional.isPresent() && toAccountOptional.isPresent()) {
            Account fromAccount = fromAccountOptional.get();
            Account toAccount = toAccountOptional.get();

            if (fromAccount.getBalance() >= amount) {
                fromAccount.setBalance(fromAccount.getBalance() - amount);

                // Usar el enum TransactionType.OUTCOME para transferencias de salida
                Transaction withdrawalTransaction = new Transaction(
                        UUID.randomUUID().toString(),
                        TransactionType.OUTCOME, // Usar el enum
                        amount,
                        new Date()
                );
                fromAccount.addTransaction(withdrawalTransaction);
                transactionService.saveTransaction(withdrawalTransaction);

                toAccount.setBalance(toAccount.getBalance() + amount);

                // Usar el enum TransactionType.INCOME para transferencias de entrada
                Transaction depositTransaction = new Transaction(
                        UUID.randomUUID().toString(),
                        TransactionType.INCOME, // Usar el enum
                        amount,
                        new Date()
                );
                toAccount.addTransaction(depositTransaction);
                transactionService.saveTransaction(depositTransaction);

                accountRepository.update(fromAccount);
                accountRepository.update(toAccount);
                return true;
            }
        }
        return false;
    }

    public void delete(UUID id) {
        accountRepository.delete(id);
    }
}