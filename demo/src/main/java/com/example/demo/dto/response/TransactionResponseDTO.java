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

    public TransactionResponseDTO(Transaction transaction, TagFinanceResponseDTO tagFinance) {
        this.title = transaction.getTitle();
        this.description = transaction.getDescription();
        this.amount = transaction.getAmount();
        this.tagId = transaction.getTagId();
        this.tagFinance = tagFinance;
    }


}
