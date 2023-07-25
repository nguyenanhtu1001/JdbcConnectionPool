package com.example.demo.entity;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.persistence.*;
import org.springframework.data.relational.core.mapping.Table;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "transaction_tag_finance")
public class TransactionTagFinance {
    @EmbeddedId
    private TransactionTagFinanceId id;
}
