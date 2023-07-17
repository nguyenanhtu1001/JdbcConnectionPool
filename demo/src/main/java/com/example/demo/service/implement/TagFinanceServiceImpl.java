package com.example.demo.service.implement;

import com.example.demo.dao.TagFinanceDAO;
import com.example.demo.dao.implement.TagFinanceDAOImpl;
import com.example.demo.dto.request.TagfinanceRequest;
import com.example.demo.dto.response.TagFinanceResponse;
import com.example.demo.entity.TagFinance;
import com.example.demo.service.TagFinanceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TagFinanceServiceImpl implements TagFinanceService {
    private final TagFinanceDAO tagFinanceDAO = new TagFinanceDAOImpl();
    public static List<TagFinanceResponse> tagFinanceDTO = new ArrayList<>();

    @Override
    public List<TagFinanceResponse> getAllTagFinance() throws Exception {
        List<TagFinance> tagFinanceList = tagFinanceDAO.getAllTagFinance();
        for (int i = 0; i < tagFinanceList.size(); i++) {
            TagFinanceResponse tagFinanceResponseDTO = new TagFinanceResponse(tagFinanceList.get(i));
            tagFinanceDTO.add(tagFinanceResponseDTO);
        }
        return tagFinanceDTO;
    }

    @Override
    public TagFinance getTagFinanceById(int id) throws Exception {
        return tagFinanceDAO.getTagFinanceById(id);
    }

    @Override
    public void createTag(TagfinanceRequest tagfinanceRequestDTO) throws Exception {
        tagFinanceDAO.createTagFinance(tagfinanceRequestDTO.getName(), tagfinanceRequestDTO.getDescription());
    }

    @Override
    public void updateTag(TagfinanceRequest tagfinanceRequestDTO, int Id) throws Exception {
        tagFinanceDAO.updateTagFinance(tagfinanceRequestDTO.getName(), tagfinanceRequestDTO.getDescription(), Id);
    }

    @Override
    public void deleteTag(int Id) throws Exception {
        tagFinanceDAO.deleteTagFinance(Id);
    }


}