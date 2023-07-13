package com.example.demo.data.dto.request;

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
    @NotEmpty(message = "Tag Finance name not blank")
    private String name;
    @NotEmpty(message = "Tag Finance description not blank")
    private String description;

    public TagfinanceRequestDTO(String name, String description) {
        this.name = name;
        this.description = description;
    }

}