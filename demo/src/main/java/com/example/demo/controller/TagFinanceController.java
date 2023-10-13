package com.example.demo.controller;

import com.example.demo.constant.MessageResponse;
import com.example.demo.dto.request.TagFinanceRequest;
import com.example.demo.dto.response.ResponseGeneral;
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
    public ResponseGeneral<TagFinanceResponse> create(@RequestBody TagFinanceRequest tagfinanceRequest) {
        return new ResponseGeneral<>(MessageResponse.Message.CREATE_TAG_SUCCESS, tagFinanceService.create(tagfinanceRequest));
    }

    @GetMapping("/get")
    public ResponseGeneral<List<TagFinanceResponse>> getAll() {
        List<TagFinanceResponse> tagFinanceResponses = tagFinanceService.getAll();
        return new ResponseGeneral<>(MessageResponse.Message.GET_TAG_SUCCESS, tagFinanceResponses);
    }

    @PutMapping("/update/{id}")
    public ResponseGeneral<TagFinanceResponse> update(@RequestBody TagFinanceRequest tagFinanceRequest, @PathVariable(name = "id") int id) {
        return new ResponseGeneral<>(MessageResponse.Message.UPDATE_TAG_SUCCESS, tagFinanceService.update(tagFinanceRequest, id));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseGeneral<Void> delete(@PathVariable(name = "id") int id) {
        tagFinanceService.delete(id);
        return new ResponseGeneral<>(MessageResponse.Message.DELETE_TAG_SUCCESS);
    }
}
