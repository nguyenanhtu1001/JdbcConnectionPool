package com.example.demo.dto.request;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Data
@Getter
@Setter
@NoArgsConstructor
public class TagfinanceRequestDTO {
    private String name;
    private String description;

    public TagfinanceRequestDTO(String name, String description) {
        this.name = name;
        this.description = description;
    }

}