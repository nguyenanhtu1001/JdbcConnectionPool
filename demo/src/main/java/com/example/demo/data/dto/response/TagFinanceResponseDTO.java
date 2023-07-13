package com.example.demo.data.dto.response;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import com.example.demo.data.entity.TagFinance;
import lombok.Setter;

@Data
@NoArgsConstructor
@Setter
@Getter
public class TagFinanceResponseDTO {
    private String name;
    private String description;
    public TagFinanceResponseDTO(TagFinance tagfinance ){
        this.name = tagfinance.getName();
        this.description = tagfinance.getDescription();
    }
}