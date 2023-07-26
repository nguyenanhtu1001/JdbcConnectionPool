package com.example.demo.controller;

import com.example.demo.constant.MessageResponse;
import com.example.demo.dto.request.TransactionRequest;
import com.example.demo.dto.response.ResponseGeneral;
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

    @GetMapping("/get")
    public ResponseGeneral<List<TransactionResponse>> getAll() {
        List<TransactionResponse> transactionResponses = transactionService.getAll();
        return new ResponseGeneral<>(MessageResponse.GET_TRAN_SUCCESS, transactionResponses);
    }

    @PostMapping("/create")
    public ResponseGeneral<TransactionResponse> create(@RequestBody TransactionRequest transactionRequest) {
        return new ResponseGeneral<>(MessageResponse.CREATE_TRAN_SUCCESS, transactionService.create(transactionRequest));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseGeneral<Void> delete(@PathVariable(name = "id") int id) {
        transactionService.delete(id);
        return new ResponseGeneral<>(MessageResponse.DELETE_TRAN_SUCCESS);
    }

    @PutMapping("/update/{id}")
    public ResponseGeneral<TransactionResponse> update(@RequestBody TransactionRequest transactionRequest, @PathVariable(name = "id") int id) {
        return new ResponseGeneral<>(MessageResponse.UPDATE_TRAN_SUCCESS, transactionService.update(transactionRequest, id));
    }
}
