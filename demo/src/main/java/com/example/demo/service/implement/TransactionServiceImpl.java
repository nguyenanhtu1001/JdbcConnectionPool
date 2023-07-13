package com.example.demo.service.implement;

import com.example.demo.dao.TagFinanceDAO;
import com.example.demo.dao.TransactionDAO;
import com.example.demo.dao.implement.TagFinanceDAOImpl;
import com.example.demo.dao.implement.TransactionDAOImpl;
import com.example.demo.data.dto.request.TransactionRequestDTO;
import com.example.demo.data.dto.response.TransactionResponseDTO;
import com.example.demo.data.entity.Transaction;
import com.example.demo.service.TransactionService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService {
    private final TagFinanceDAO tagFinanceDAO= new TagFinanceDAOImpl();
    private final TransactionDAO transactionDAO = new TransactionDAOImpl();

    public static List<TransactionResponseDTO> transactionDTO = new ArrayList<>();

    @Override
    public void create(TransactionRequestDTO transactionRequestDTO){
            transactionDAO.createTransaction(transactionRequestDTO.getTitle(),
                transactionRequestDTO.getDescription(),
                transactionRequestDTO.getAmount(),
                transactionRequestDTO.getTagId());
    }

    @Override
    public void updateTransaction(TransactionRequestDTO transactionRequestDTO, int tagId) throws Exception {
        transactionDAO.updateTransaction(transactionRequestDTO.getTitle(),
                transactionRequestDTO.getDescription(),
                transactionRequestDTO.getAmount(),
                transactionRequestDTO.getTagId());
    }

    @Override
    public void deleteTransaction( int tagId) throws Exception {
        transactionDAO.deleteTransaction(tagId);
    }

    @Override
    public List<TransactionResponseDTO> getTransaction() throws Exception {
        List<Transaction> transactionList = transactionDAO.getAllTransactions();
        for (int i = 0; i < transactionList.size(); i++) {
            TransactionResponseDTO transactionResponseDTO = new TransactionResponseDTO(transactionList.get(i));
            transactionDTO.add(transactionResponseDTO);
        }
        return transactionDTO;
    }
}
