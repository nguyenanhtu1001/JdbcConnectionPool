package com.example.demo.entity;

import com.example.demo.dto.request.TransactionRequest;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.relational.core.mapping.Table;

import java.io.Serializable;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "transactions")
public class Transaction implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "created_at")
    private Date createdAt;
    @Column(name = "title")
    private String title;
    @Column(name = "description")
    private String description;
    @Column(name = "amount")
    private double amount;

    public Transaction(String title, String description, double amount) {
        this.title = title;
        this.description = description;
        this.amount = amount;
    }
}