package com.example.demo.service.implement;

import com.example.demo.dao.TagFinanceDAO;
import com.example.demo.dao.TransactionDAO;
import com.example.demo.dao.implement.TagFinanceDAOImpl;
import com.example.demo.dao.implement.TransactionDAOImpl;
import com.example.demo.dto.request.TransactionRequest;
import com.example.demo.dto.response.TagFinanceResponse;
import com.example.demo.dto.response.TransactionResponse;
import com.example.demo.entity.TagFinance;
import com.example.demo.entity.Transaction;
import com.example.demo.service.TransactionService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService {
    private final TagFinanceDAO tagFinanceDAO = new TagFinanceDAOImpl();
    private final TransactionDAO transactionDAO = new TransactionDAOImpl();

    public static List<TransactionResponse> transactionDTO = new ArrayList<>();

    @Override
    public void create(TransactionRequest transactionRequestDTO) {
        transactionDAO.createTransaction(transactionRequestDTO.getTitle(),
                transactionRequestDTO.getDescription(),
                transactionRequestDTO.getAmount(),
                transactionRequestDTO.getTagId());
    }

    @Override
    public void updateTransaction(TransactionRequest transactionRequestDTO, int id) throws Exception {
        transactionDAO.updateTransaction(transactionRequestDTO.getTitle(),
                transactionRequestDTO.getDescription(),
                transactionRequestDTO.getAmount(),
                transactionRequestDTO.getTagId(), id);
    }

    @Override
    public void deleteTransaction(int id) throws Exception {
        transactionDAO.deleteTransaction(id);
    }

    @Override
    public List<TransactionResponse> getTransaction() throws Exception {
        List<Transaction> transactionList = transactionDAO.getAllTransactions();
        for (int i = 0; i < transactionList.size(); i++) {
            System.out.println(transactionList.get(i).getTagId());
            TagFinance tagFinance = tagFinanceDAO.getTagFinanceById(transactionList.get(i).getTagId());
            TagFinanceResponse tagFinanceResponseDTO = new TagFinanceResponse(tagFinance);
            TransactionResponse transactionResponseDTO = new TransactionResponse(transactionList.get(i), tagFinanceResponseDTO);
            transactionDTO.add(transactionResponseDTO);
        }
        return transactionDTO;

    }
}
