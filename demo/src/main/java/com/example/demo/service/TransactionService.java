package com.example.demo.service;

import com.example.demo.dto.request.TransactionRequest;
import com.example.demo.dto.response.TransactionResponse;

import java.util.List;

public interface TransactionService {
    TransactionResponse create(TransactionRequest transactionrequest);

    TransactionResponse update(TransactionRequest transactionRequest, int id);

    void delete(int id);

    List<TransactionResponse> getAll();
}