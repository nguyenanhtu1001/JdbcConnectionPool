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
public class TransactionResponse {
    private String title;
    private String description;
    private double amount;
    private int tagId;
    private TagFinanceResponse tagFinance;

    public TransactionResponse(Transaction transaction, TagFinanceResponse tagFinance) {
        this.title = transaction.getTitle();
        this.description = transaction.getDescription();
        this.amount = transaction.getAmount();
        this.tagId = transaction.getTagId();
        this.tagFinance = tagFinance;
    }


}
