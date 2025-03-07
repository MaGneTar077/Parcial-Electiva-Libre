package com.microservice.microservices.infrastructure.controller;

import com.microservice.microservices.domain.entity.Transaction;
import com.microservice.microservices.application.service.TransactionService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @GetMapping("/")
    public List<Transaction> getAllTransactions() {
        return transactionService.getAllTransactions();
    }

    @PostMapping("/save")
    public Transaction saveTransaction(@RequestBody Transaction transactions) {
        return transactionService.saveTransaction(transactions);
    }

    @PostMapping("/process")
    public Transaction createTransaction(@RequestBody Transaction transaction) {
        return transactionService.processTransaction(transaction);
    }
}