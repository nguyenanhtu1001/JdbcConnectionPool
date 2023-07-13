package com.example.demo.service;

import com.example.demo.data.dto.request.TagfinanceRequestDTO;
import com.example.demo.data.dto.response.TagFinanceResponseDTO;
import com.example.demo.data.entity.TagFinance;

import java.util.List;

public interface TagFinanceService {
    void createTag(TagfinanceRequestDTO tagfinanceRequestDTO) throws Exception;
    void updateTag(int Id, TagfinanceRequestDTO tagfinanceRequestDTO) throws Exception;
    void deleteTag(int Id) throws Exception;
    List<TagFinanceResponseDTO> getAllTagFinance() throws Exception;
    TagFinance getTagFinanceById(int id) throws Exception;
}