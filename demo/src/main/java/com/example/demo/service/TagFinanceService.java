package com.example.demo.service;

import com.example.demo.dto.request.TagFinanceRequest;
import com.example.demo.dto.response.TagFinanceResponse;

import java.util.List;

public interface TagFinanceService {
    TagFinanceResponse create(TagFinanceRequest tagFinanceRequest);

    TagFinanceResponse update(TagFinanceRequest tagFinanceRequest, int id);

    void delete(int id);

    List<TagFinanceResponse> getAll();

    TagFinanceResponse getById(int id);

}