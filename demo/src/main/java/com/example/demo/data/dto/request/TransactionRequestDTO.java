package com.example.demo.data.dto.request;
import lombok.*;

import javax.validation.constraints.NotEmpty;
@Data
@Getter
@Setter
@NoArgsConstructor
public class TransactionRequestDTO {
    @NotEmpty(message="transaction title not blank ")
    private String title;
    @NotEmpty(message="transaction description not blank ")
    private String description;
    @NotEmpty(message="transaction amount not blank ")
    private double amount;
    @NotEmpty(message="transaction tagId not blank ")
    private int tagId;

    public TransactionRequestDTO(String title, String description, double amount, int tagId) {
        this.title = title;
        this.description = description;
        this.amount = amount;
        this.tagId = tagId;
    }
}