package com.microservice.microservices.infrastructure.controller;

import com.microservice.microservices.domain.entity.Transactions;
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
public List<Transactions>getAllTransactions(){
    return transactionService.getAllTransactions();
}



@PostMapping("/")
public Transactions saveTransaction(@RequestBody Transactions transactions){
    return transactionService.saveTransaction(transactions);
}


@PostMapping("/")
    public Transactions createTransaction(@RequestBody Transactions transaction) {
        return transactionService.processTransaction(transaction);
    }


}
