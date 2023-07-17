package com.example.demo.controller;

import com.example.demo.dto.request.TransactionRequest;
import com.example.demo.dto.response.TransactionResponse;
import com.example.demo.service.TransactionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/transactions")
public class TransactionController {
    private TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }


    @GetMapping("get")
    public List<TransactionResponse> getAll() throws Exception {
        List<TransactionResponse> list = transactionService.getTransaction();
        return list;
    }

    @PostMapping("create")
    public TransactionRequest create(@RequestBody TransactionRequest transactionRequestDTO) throws Exception {
        transactionService.create(transactionRequestDTO);
        return transactionRequestDTO;
    }

    @DeleteMapping("delete/{id}")
    public void delete(@PathVariable(name = "id") int id) throws Exception {
        transactionService.deleteTransaction(id);
    }

    @PutMapping("update/{id}")
    public void update(@RequestBody TransactionRequest transactionRequestDTO, @PathVariable(name = "id") int id) throws Exception {
        transactionService.updateTransaction(transactionRequestDTO, id);
    }
}
