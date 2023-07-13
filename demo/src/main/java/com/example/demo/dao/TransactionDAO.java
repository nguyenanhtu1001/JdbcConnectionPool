package com.example.demo.dao;

import com.example.demo.data.entity.Transaction;

import java.util.List;

public interface TransactionDAO {
    List<Transaction> getAllTransactions();

    void createTransaction(String title, String description, double amount, int tagId);

    void updateTransaction(String title, String description, double amount, int tagId) ;

    void deleteTransaction(int id);

}
