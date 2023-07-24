package com.example.demo.dto.response;

import lombok.Getter;
import com.example.demo.entity.TagFinance;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class TagFinanceResponse {
    private String name;
    private String description;

    public TagFinanceResponse(String name, String description) {
        this.name = name;
        this.description = description;
    }
    public TagFinanceResponse(TagFinance tagFinance){
        this.name = tagFinance.getName();
        this.description = tagFinance.getDescription();
    }
}