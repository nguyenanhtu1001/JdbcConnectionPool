package com.example.demo.controller;

import com.example.demo.dto.request.TagfinanceRequest;
import com.example.demo.dto.response.TagFinanceResponse;
import com.example.demo.service.TagFinanceService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/tag-finances")
public class TagFinanceController {
    private final TagFinanceService tagFinanceService;

    public TagFinanceController(TagFinanceService tagFinanceService) {
        this.tagFinanceService = tagFinanceService;
    }

    @PostMapping("/create")
    public TagfinanceRequest create(@RequestBody TagfinanceRequest tagfinanceRequestDTO) throws Exception {
        tagFinanceService.createTag(tagfinanceRequestDTO);
        return tagfinanceRequestDTO;
    }

    @GetMapping("/get")
    public List<TagFinanceResponse> getTagFinance() throws Exception {
        List<TagFinanceResponse> list = tagFinanceService.getAllTagFinance();
        return list;
    }

    @PutMapping("/update/{id}")
    public void update(@RequestBody TagfinanceRequest tagfinanceRequestDTO, @PathVariable(name = "id") int id) throws Exception {
        tagFinanceService.updateTag(tagfinanceRequestDTO,id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteTagFinance(@PathVariable(name = "id") int tagId) throws Exception {
        tagFinanceService.deleteTag(tagId);
    }

}