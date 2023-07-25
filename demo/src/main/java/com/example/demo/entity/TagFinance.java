package com.example.demo.entity;

import com.example.demo.dto.request.TagfinanceRequest;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.relational.core.mapping.Table;

import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "tag_finances")
public class TagFinance implements Serializable {
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