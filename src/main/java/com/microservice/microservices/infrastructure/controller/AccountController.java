package com.microservice.microservices.infrastructure.controller;

import com.microservice.microservices.application.service.AccountService;
import com.microservice.microservices.domain.entity.Account;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/account")
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping
    public ResponseEntity<Account> createAccount(@RequestBody Account account) {
        Account createdAccount = accountService.createAccount(account);
        return new ResponseEntity<>(createdAccount, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Account> getAccountById(@PathVariable UUID id) {
        Optional<Account> account = accountService.getAccountById(id);
        return account.map(ResponseEntity::ok)
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/recharge")
    public ResponseEntity<Void> recharge(@RequestParam UUID accountId, @RequestParam double amount) {
        boolean success = accountService.deposit(accountId, amount);
        return success ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }

    @PostMapping("/purchase")
    public ResponseEntity<Void> purchase(@RequestParam UUID accountId, @RequestParam double amount) {
        boolean success = accountService.withdraw(accountId, amount);
        return success ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }

    @PostMapping("/send")
    public ResponseEntity<Void> sendMoney(
            @RequestParam UUID fromAccountId,
            @RequestParam UUID toAccountId,
            @RequestParam double amount) {
        boolean success = accountService.transfer(fromAccountId, toAccountId, amount);
        return success ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }
}