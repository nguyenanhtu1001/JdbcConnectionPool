package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.relational.core.mapping.Table;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "tag_finances")
public class TagFinance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;

    public TagFinance(String name, String description) {
        this.name = name;
        this.description = description;
    }
}