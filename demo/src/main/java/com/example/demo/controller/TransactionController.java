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
    public ResponseEntity<List<TransactionResponse>> getAll() {
        List<TransactionResponse> transactionResponses = transactionService.getAll();
        return new ResponseEntity<>(transactionResponses, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<TransactionResponse> create(@RequestBody TransactionRequest transactionRequest) {
        return new ResponseEntity<>(transactionService.create(transactionRequest), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable(name = "id") int id) {
        transactionService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<TransactionResponse> update(@RequestBody TransactionRequest transactionRequest, @PathVariable(name = "id") int id) {
        return new ResponseEntity<>(transactionService.update(transactionRequest, id), HttpStatus.OK);
    }
}
