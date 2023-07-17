package com.example.demo.dto.response;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import com.example.demo.entity.TagFinance;
import lombok.Setter;

@Data
@NoArgsConstructor
@Setter
@Getter
public class TagFinanceResponse {
    private String name;
    private String description;
    public TagFinanceResponse(TagFinance tagfinance ){
        this.name = tagfinance.getName();
        this.description = tagfinance.getDescription();
    }
}