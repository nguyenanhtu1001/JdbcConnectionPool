package com.example.demo.service;

import com.example.demo.dto.request.TagfinanceRequest;
import com.example.demo.dto.response.TagFinanceResponse;
import com.example.demo.entity.TagFinance;

import java.util.List;

public interface TagFinanceService {
    void createTag(TagfinanceRequest tagfinanceRequestDTO) throws Exception;

    void updateTag(TagfinanceRequest tagfinanceRequestDTO, int Id) throws Exception;

    void deleteTag(int Id) throws Exception;

    List<TagFinanceResponse> getAllTagFinance() throws Exception;

    TagFinance getTagFinanceById(int id) throws Exception;
}