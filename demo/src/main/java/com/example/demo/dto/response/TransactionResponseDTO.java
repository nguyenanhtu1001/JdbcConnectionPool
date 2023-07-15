package com.example.demo.dto.response;

import com.example.demo.entity.Transaction;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@NoArgsConstructor
public class TransactionResponseDTO {
    private String title;
    private String description;
    private double amount;
    private int tagId;
    private TagFinanceResponseDTO tagFinance;

    public TransactionResponseDTO(String title, String description, int amount, int tagId, TagFinanceResponseDTO tagFinance) {
        this.title = title;
        this.description = description;
        this.amount = amount;
        this.tagId = tagId;
        this.tagFinance = tagFinance;
    }

    public TransactionResponseDTO(Transaction transaction) {
        this.title = transaction.getTitle();
        this.description = transaction.getDescription();
        this.amount = transaction.getAmount();
        this.tagId = transaction.getTagId();
        this.tagFinance = new TagFinanceResponseDTO(transaction.getTagFinance());
    }
}