package com.example.demo.service;

import com.example.demo.dto.request.TagFinanceRequest;
import com.example.demo.dto.response.TagFinanceResponse;

import java.util.List;

public interface TagFinanceService {
    TagFinanceResponse createTagFinance(TagFinanceRequest tagFinanceRequest);

    TagFinanceResponse updateTagFinance(TagFinanceRequest tagfinanceRequest, int id);

    void deleteTagFinance(int id);

    List<TagFinanceResponse> getAllTagFinance();

    TagFinanceResponse getTagFinanceById(int id);

}