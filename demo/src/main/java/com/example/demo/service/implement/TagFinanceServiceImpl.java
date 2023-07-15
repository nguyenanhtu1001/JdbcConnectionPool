package com.example.demo.service.implement;

import com.example.demo.dao.TagFinanceDAO;
import com.example.demo.dao.implement.TagFinanceDAOImpl;
import com.example.demo.dto.request.TagfinanceRequestDTO;
import com.example.demo.dto.response.TagFinanceResponseDTO;
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
    public static List<TagFinanceResponseDTO> tagFinanceDTO = new ArrayList<>();

    @Override
    public List<TagFinanceResponseDTO> getAllTagFinance() throws Exception {
        List<TagFinance> tagFinanceList = tagFinanceDAO.getAllTagFinance();
        for (int i = 0; i < tagFinanceList.size(); i++) {
            TagFinanceResponseDTO tagFinanceResponseDTO = new TagFinanceResponseDTO(tagFinanceList.get(i));
            tagFinanceDTO.add(tagFinanceResponseDTO);
        }
        return tagFinanceDTO;
    }

    @Override
    public TagFinance getTagFinanceById(int id) throws Exception {
        return tagFinanceDAO.getTagFinanceById(id);
    }

    @Override
    public void createTag(TagfinanceRequestDTO tagfinanceRequestDTO) throws Exception {
        tagFinanceDAO.createTagFinance(tagfinanceRequestDTO.getName(), tagfinanceRequestDTO.getDescription());
    }

    @Override
    public void updateTag(int Id, TagfinanceRequestDTO tagfinanceRequestDTO) throws Exception {
        tagFinanceDAO.updateTagFinance(Id, tagfinanceRequestDTO.getName(), tagfinanceRequestDTO.getDescription());
    }

    @Override
    public void deleteTag(int Id) throws Exception {
        tagFinanceDAO.deleteTagFinance(Id);
    }


}