package com.example.demo.dto.request;

import lombok.*;

import javax.validation.constraints.NotEmpty;

@Data
@Getter
@Setter
@NoArgsConstructor
public class TransactionRequestDTO {
    private String title;
    private String description;
    private double amount;
    private int tagId;

    public TransactionRequestDTO(String title, String description, double amount, int tagId) {
        this.title = title;
        this.description = description;
        this.amount = amount;
        this.tagId = tagId;
    }
}