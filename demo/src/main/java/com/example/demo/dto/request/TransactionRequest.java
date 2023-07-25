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
}