package com.example.demo.controller;

import com.example.demo.dto.request.TagFinanceRequest;
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

    public ResponseEntity<TagFinanceResponse> createTagFinance(@RequestBody TagFinanceRequest tagfinanceRequest) {
        return new ResponseEntity<>(tagFinanceService.createTagFinance(tagfinanceRequest), HttpStatus.OK);
    }

    @GetMapping("/get")
    public ResponseEntity<List<TagFinanceResponse>> getTagFinance() {
        List<TagFinanceResponse> tagFinanceResponses = tagFinanceService.getAllTagFinance();
        return new ResponseEntity<>(tagFinanceResponses, HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<TagFinanceResponse>
    updateTagFinance(@RequestBody TagFinanceRequest tagFinanceRequest, @PathVariable(name = "id") int id) {
        return new ResponseEntity<>(tagFinanceService.updateTagFinance(tagFinanceRequest, id), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteTagFinance(@PathVariable(name = "id") int id){
        tagFinanceService.deleteTagFinance(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}