package com.example.demo.dao;

import com.example.demo.entity.TagFinance;

import java.sql.SQLException;
import java.util.List;

public interface TagFinanceDAO {

    void updateTagFinance(String name, String description, int id) throws Exception;

    List<TagFinance> getAllTagFinance() throws Exception;

    void deleteTagFinance(int id);

    TagFinance getTagFinanceById(int id) throws Exception;

    void createTagFinance(String name, String description) throws SQLException;
}
