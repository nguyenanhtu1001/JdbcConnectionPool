package com.example.demo.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class TagFinanceRequest {
    private String name;
    private String description;

    public TagFinanceRequest(String name, String description) {
        this.name = name;
        this.description = description;
    }

}