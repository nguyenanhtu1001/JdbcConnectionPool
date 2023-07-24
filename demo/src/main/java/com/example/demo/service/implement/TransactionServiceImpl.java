package com.example.demo.service.implement;

import com.example.demo.dao.TagFinanceDAO;
import com.example.demo.dao.TransactionDAO;
import com.example.demo.dao.implement.TagFinanceDAOImpl;
import com.example.demo.dao.implement.TransactionDAOImpl;
import com.example.demo.dto.request.TransactionRequest;
import com.example.demo.dto.response.TransactionResponse;
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
    public TransactionResponse createTransaction(TransactionRequest request) {
        TransactionResponse transactionResponse= new TransactionResponse(transactionDAO.createTransaction(request));
        return transactionResponse;
    }

    @Override
    public TransactionResponse updateTransaction(TransactionRequest transactionRequest, int id) {
        Transaction transactionUpdate = new Transaction(
                transactionRequest.getTitle(),
                transactionRequest.getDescription(),
                transactionRequest.getAmount());
        TransactionResponse transactionResponse = new TransactionResponse(
                transactionDAO.updateTransaction(transactionUpdate,id));
        return transactionResponse;
    }

    @Override
    public void deleteTransaction(int id) {
        transactionDAO.deleteTransaction(id);
    }

    @Override
    public List<TransactionResponse> getTransaction() {
        List<TransactionResponse> transactionList = transactionDAO.getAllTransactions();

        for (TransactionResponse transaction : transactionList) {
            TransactionResponse transactionResponse = new TransactionResponse(
                    transaction.getId(),
                    transaction.getTitle(),
                    transaction.getDescription(),
                    transaction.getAmount(),
                    transaction.getTagId());
            transactionDTO.add(transactionResponse);
        }
        return transactionDTO;
    }


}
