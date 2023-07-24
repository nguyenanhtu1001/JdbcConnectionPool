package com.example.demo.dto.request;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class TransactionRequest {
    private String title;
    private String description;
    private double amount;
    private List<Integer> tagId;

    public TransactionRequest(String title, String description, double amount, List<Integer> tagId) {
        this.title = title;
        this.description = description;
        this.amount = amount;
        this.tagId = tagId;
    }
}