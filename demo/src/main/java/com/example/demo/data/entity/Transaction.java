package com.example.demo.data.entity;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.relational.core.mapping.Table;

import java.io.Serializable;
@Entity
@Data
@Getter
@Setter
@Table(name ="Transactions")
public class Transaction implements Serializable{
    @Column(name = "createdAt")
    private String createdAt;
    @Column(name = "title")
    private String title;
    @Column(name = "description")
    private String description;
    @Column(name = "amount")
    private double amount;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tagId")
    private int tagId;
    private TagFinance tagFinance;

//    public Transactions(String createAt, String title, String description, double amount, int tagId, TagFinance tagFinance) {
//    }

    public Transaction(String createdAt, String title, String description, double amount, int tagId) {
        this.createdAt = createdAt;
        this.title = title;
        this.description = description;
        this.amount = amount;
        this.tagId = tagId;
    }
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