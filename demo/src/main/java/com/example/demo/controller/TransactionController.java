package com.example.demo.controller;

import com.example.demo.dto.request.TransactionRequest;
import com.example.demo.dto.response.TransactionResponse;
import com.example.demo.service.TransactionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/transactions")
public class TransactionController {
    private TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @GetMapping("/get")
    public ResponseEntity<List<TransactionResponse>> getAllTransaction() {
        List<TransactionResponse> transactionResponses = transactionService.getTransaction();
        return new ResponseEntity<>(transactionResponses, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<TransactionResponse>
    createTransaction(@RequestBody TransactionRequest transactionRequest) {
        return new ResponseEntity<>(transactionService.createTransaction(transactionRequest), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteTransaction(@PathVariable(name = "id") int id) {
        transactionService.deleteTransaction(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<TransactionResponse>
    updateTransaction(@RequestBody TransactionRequest transactionRequest, @PathVariable(name = "id") int id) {
        return new ResponseEntity<>(transactionService.updateTransaction(transactionRequest, id), HttpStatus.OK);
    }
}
