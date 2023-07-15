package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.relational.core.mapping.Table;

import java.io.Serializable;

@Entity
@Data
@Getter
@Setter
@Table(name = "Transactions")
public class Transaction implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "Create_at")
    private String createdAt;
    @Column(name = "title")
    private String title;
    @Column(name = "description")
    private String description;
    @Column(name = "amount")
    private double amount;
    @Column(name = "Tag_id")
    private int tagId;
    private TagFinance tagFinance;

    public Transaction(String createdAt, String title, String description, double amount, int tagId, TagFinance tagFinance) {
        this.createdAt = createdAt;
        this.title = title;
        this.description = description;
        this.amount = amount;
        this.tagId = tagId;
        this.tagFinance = tagFinance;
    }

    public void setTagFinance(TagFinance tagFinance) {
        this.tagFinance = tagFinance;
    }

    public TagFinance getTagFinance() {
        return tagFinance;
    }

}