package com.example.demo.service;

import com.example.demo.dto.request.TransactionRequest;
import com.example.demo.dto.response.TransactionResponse;

import java.util.List;

public interface TransactionService {
    TransactionResponse createTransaction(TransactionRequest transactionrequest);

    TransactionResponse updateTransaction(TransactionRequest transactionRequest, int id);

    void deleteTransaction(int id);

    List<TransactionResponse> getTransaction();
}