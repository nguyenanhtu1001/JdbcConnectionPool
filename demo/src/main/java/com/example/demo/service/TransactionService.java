package com.example.demo.service;

import com.example.demo.dto.request.TransactionRequestDTO;
import com.example.demo.dto.response.TransactionResponseDTO;

import java.util.List;

public interface TransactionService {
    void create(TransactionRequestDTO transactionRequestDTO) throws Exception;

    void updateTransaction(TransactionRequestDTO transactionRequestDTO, int id) throws Exception;

    void deleteTransaction(int id) throws Exception;

    List<TransactionResponseDTO> getTransaction() throws Exception;
}