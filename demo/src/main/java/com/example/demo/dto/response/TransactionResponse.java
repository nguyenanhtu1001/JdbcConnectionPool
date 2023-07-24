package com.example.demo.dto.response;

import com.example.demo.dto.request.TransactionRequest;
import com.example.demo.entity.Transaction;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
@NoArgsConstructor
public class TransactionResponse {
    private String title;
    private String description;
    private double amount;
    private int id;
    private List<Integer> tagId;



    public TransactionResponse(TransactionRequest transaction) {
        this.title = transaction.getTitle();
        this.description = transaction.getDescription();
        this.amount = transaction.getAmount();
        this.tagId = transaction.getTagId();
    }
    public TransactionResponse(Transaction transaction){
        this.title = transaction.getTitle();
        this.description = transaction.getDescription();
        this.amount = transaction.getAmount();
    }

    public TransactionResponse(int id, String title, String description, double amount, List<Integer> tagId) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.amount = amount;
        this.tagId = tagId;
    }
    public TransactionResponse(String title, String description, double amount, List<Integer> tagId) {
        this.title = title;
        this.description = description;
        this.amount = amount;
        this.tagId = tagId;
    }
}
