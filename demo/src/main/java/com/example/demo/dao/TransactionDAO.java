package com.example.demo.dao;

import com.example.demo.dto.request.TransactionRequest;
import com.example.demo.dto.response.TransactionResponse;
import com.example.demo.entity.Transaction;

import java.util.List;

public interface TransactionDAO {
    List<TransactionResponse> getAllTransactions();

    Transaction createTransaction(Transaction transaction, List<Integer> tagIds);

    Transaction updateTransaction(Transaction transaction, int id);

    void deleteTransaction(int id);

}
