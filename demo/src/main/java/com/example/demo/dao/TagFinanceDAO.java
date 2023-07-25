package com.example.demo.dao;

import com.example.demo.entity.TagFinance;

import java.util.List;

public interface TagFinanceDAO {

    TagFinance updateTagFinance(TagFinance tagFinance, int id);

    List<TagFinance> getAllTagFinance();

    void deleteTagFinance(int transactionId,int tagId);

    TagFinance getTagFinanceById(int id);

    TagFinance createTagFinance(TagFinance tagFinance);

}
