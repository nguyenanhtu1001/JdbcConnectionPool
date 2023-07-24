package com.example.demo.controller;

import com.example.demo.dto.request.TagfinanceRequest;
import com.example.demo.dto.response.TagFinanceResponse;
import com.example.demo.service.TagFinanceService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;

import java.util.List;

@RestController
@RequestMapping("api/v1/tag-finances")
public class TagFinanceController {
    private final TagFinanceService tagFinanceService;

    public TagFinanceController(TagFinanceService tagFinanceService) {
        this.tagFinanceService = tagFinanceService;
    }

    @PostMapping("/create")

    public ResponseEntity<TagFinanceResponse> CreateTagFinance(@RequestBody TagfinanceRequest tagfinanceRequest) {
        return new ResponseEntity<>(tagFinanceService.createTagFinance(tagfinanceRequest),HttpStatus.OK);
    }

    @GetMapping("/get")
    public List<TagFinanceResponse> getTagFinance() {
        List<TagFinanceResponse> listResponse = tagFinanceService.getAllTagFinance();
        return listResponse;
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<TagFinanceResponse>
    update(@RequestBody TagfinanceRequest tagfinance, @PathVariable(name = "id") int Id) {
        return new ResponseEntity<>(tagFinanceService.updateTagFinance(tagfinance,Id),HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteTagFinance(@PathVariable(name = "id") int tagId) {
        tagFinanceService.deleteTagFinance(tagId);
    }

}