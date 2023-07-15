package com.example.demo.controller;

import com.example.demo.dto.request.TransactionRequestDTO;
import com.example.demo.dto.response.TransactionResponseDTO;
import com.example.demo.service.TransactionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("transactions")
public class TransactionController {
    private TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }


    @GetMapping("get")
    public List<TransactionResponseDTO> getAll() throws Exception {
        List<TransactionResponseDTO> list = transactionService.getTransaction();
        return list;
    }

    @PostMapping("create")
    public TransactionRequestDTO create(@RequestBody TransactionRequestDTO transactionRequestDTO) throws Exception {
        transactionService.create(transactionRequestDTO);
        return transactionRequestDTO;
    }

    @DeleteMapping("delete/{id}")
    public void delete(@PathVariable(name = "id") int id) throws Exception {
        transactionService.deleteTransaction(id);
    }

    @PutMapping("update/{id}")
    public void update(@RequestBody TransactionRequestDTO transactionRequestDTO, @PathVariable(name = "id") int id) throws Exception {
        transactionService.updateTransaction(transactionRequestDTO, id);
    }
}
