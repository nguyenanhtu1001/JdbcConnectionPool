package com.example.demo.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class TagfinanceRequest {
    private String name;
    private String description;

    public TagfinanceRequest(String name, String description) {
        this.name = name;
        this.description = description;
    }

}