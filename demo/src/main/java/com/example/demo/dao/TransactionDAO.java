package com.example.demo.dao;

import com.example.demo.dto.response.TransactionResponse;
import com.example.demo.model.Transaction;

import java.util.List;

public interface TransactionDAO {
    List<TransactionResponse> getAll();

    Transaction create(Transaction transaction, List<Integer> tagIds);

    Transaction update(Transaction transaction, int id);

    void delete(int id);

}
