package com.example.demo.dao;

import com.example.demo.model.TagFinance;

import java.util.List;

public interface TagFinanceDAO {

    TagFinance update(TagFinance tagFinance, int id);

    List<TagFinance> getAll();

    void delete(int id);

    TagFinance getById(int id);

    TagFinance create(TagFinance tagFinance);

}
