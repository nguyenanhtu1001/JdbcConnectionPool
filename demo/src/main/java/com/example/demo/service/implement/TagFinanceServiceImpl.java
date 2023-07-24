package com.example.demo.service.implement;

import com.example.demo.dao.TagFinanceDAO;
import com.example.demo.dao.implement.TagFinanceDAOImpl;
import com.example.demo.dto.request.TagfinanceRequest;
import com.example.demo.dto.response.TagFinanceResponse;
import com.example.demo.entity.TagFinance;
import com.example.demo.service.TagFinanceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TagFinanceServiceImpl implements TagFinanceService {
    private final TagFinanceDAO tagFinanceDAO = new TagFinanceDAOImpl();
    public static List<TagFinanceResponse> tagFinanceDTO = new ArrayList<>();

    @Override
    public List<TagFinanceResponse> getAllTagFinance() {
        List<TagFinance> tagFinanceList = tagFinanceDAO.getAllTagFinance();

        for (TagFinance tagFinance : tagFinanceList) {
            String name = tagFinance.getName();
            String description = tagFinance.getDescription();
            TagFinanceResponse tagFinanceResponse = new TagFinanceResponse(name, description);
            tagFinanceDTO.add(tagFinanceResponse);
        }
        return tagFinanceDTO;
    }


    @Override
    public TagFinanceResponse getTagFinanceById(int id) {
        TagFinance tagFinance = tagFinanceDAO.getTagFinanceById(id);
        String name = tagFinance.getName();
        String description = tagFinance.getDescription();
        TagFinanceResponse tagFinanceResponse = new TagFinanceResponse(name, description);
        return tagFinanceResponse;
    }

    @Override
    public TagFinanceResponse createTagFinance(TagfinanceRequest tagfinanceRequest) {
        TagFinance tagFinance = new TagFinance(tagfinanceRequest.getName(), tagfinanceRequest.getDescription());
        TagFinanceResponse response = new TagFinanceResponse(tagFinanceDAO.createTagFinance(tagFinance));
        return response;
    }


    @Override
    public TagFinanceResponse updateTagFinance(TagfinanceRequest tagfinanceRequest, @PathVariable(name = "id") int Id) {
        TagFinance tagfinanceUpdate = new TagFinance(
                tagfinanceRequest.getName(),
                tagfinanceRequest.getDescription());
        tagFinanceDAO.updateTagFinance(tagfinanceUpdate, Id);
        TagFinanceResponse tagFinanceResponse = new TagFinanceResponse(tagfinanceUpdate.getName(), tagfinanceUpdate.getDescription());
        return tagFinanceResponse;
    }

    @Override
    public void deleteTagFinance(int Id) {
        tagFinanceDAO.deleteTagFinance(Id);
    }


}