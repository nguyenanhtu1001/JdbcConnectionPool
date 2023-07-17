package com.example.demo.service;

import com.example.demo.dto.request.TransactionRequest;
import com.example.demo.dto.response.TransactionResponse;

import java.util.List;

public interface TransactionService {
    void create(TransactionRequest transactionRequestDTO) throws Exception;

    void updateTransaction(TransactionRequest transactionRequestDTO, int id) throws Exception;

    void deleteTransaction(int id) throws Exception;

    List<TransactionResponse> getTransaction() throws Exception;
}