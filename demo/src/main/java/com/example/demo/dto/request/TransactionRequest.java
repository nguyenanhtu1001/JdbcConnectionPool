package com.example.demo.dto.request;

import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
public class TransactionRequest {
    private String title;
    private String description;
    private double amount;
    private int tagId;

    public TransactionRequest(String title, String description, double amount, int tagId) {
        this.title = title;
        this.description = description;
        this.amount = amount;
        this.tagId = tagId;
    }
}