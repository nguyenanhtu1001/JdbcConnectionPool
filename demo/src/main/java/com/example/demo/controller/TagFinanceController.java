package com.example.demo.controller;

import com.example.demo.dto.request.TagfinanceRequestDTO;
import com.example.demo.dto.response.TagFinanceResponseDTO;
import com.example.demo.service.TagFinanceService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tagfinances")
public class TagFinanceController {
    private final TagFinanceService tagFinanceService;

    public TagFinanceController(TagFinanceService tagFinanceService) {
        this.tagFinanceService = tagFinanceService;
    }

    @PostMapping("/create")
    public TagfinanceRequestDTO create(@RequestBody TagfinanceRequestDTO tagFinance) throws Exception {
        tagFinanceService.createTag(tagFinance);
        return tagFinance;
    }

    @GetMapping("/get")
    public List<TagFinanceResponseDTO> getTagFinance() throws Exception {
        List<TagFinanceResponseDTO> list = tagFinanceService.getAllTagFinance();
        return list;
    }

    @PutMapping("/update/{id}")
    public void update(@RequestBody TagfinanceRequestDTO tagFinance, @PathVariable(name = "id") int id) throws Exception {
        tagFinanceService.updateTag(id, tagFinance);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteTagFinance(@PathVariable(name = "id") int tagId) throws Exception {
        tagFinanceService.deleteTag(tagId);
    }

}