package com.example.demo.service;

import com.example.demo.dto.request.TagfinanceRequest;
import com.example.demo.dto.response.TagFinanceResponse;
import com.example.demo.entity.TagFinance;

import java.util.List;

public interface TagFinanceService {
    TagFinanceResponse createTagFinance(TagfinanceRequest tagFinanceRequest);

    TagFinanceResponse updateTagFinance(TagfinanceRequest tagfinanceRequest, int id);

    void deleteTagFinance(int id);

    List<TagFinanceResponse> getAllTagFinance();

    TagFinanceResponse getTagFinanceById(int id);

}