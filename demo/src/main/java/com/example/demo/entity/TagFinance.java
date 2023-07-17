package com.example.demo.entity;

import com.example.demo.dto.request.TagfinanceRequestDTO;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.relational.core.mapping.Table;

import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "Tag_Finances")
public class TagFinance implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;

    public TagFinance(int id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

}