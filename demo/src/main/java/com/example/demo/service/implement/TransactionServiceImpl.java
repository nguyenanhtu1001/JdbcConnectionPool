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
    public TransactionResponse createTransaction(TransactionRequest request) {
        Transaction transaction = new Transaction(
                request.getTitle(),
                request.getDescription(),
                request.getAmount());
        List<Integer> tagIds = request.getTagId();
        Transaction createdTransaction = transactionDAO.createTransaction(transaction, tagIds);
        TransactionResponse transactionResponse = new TransactionResponse(request, tagIds);

        return transactionResponse;
    }


    @Override
    public TransactionResponse updateTransaction(TransactionRequest transactionRequest, int id) {
        Transaction transactionUpdate = new Transaction(
                transactionRequest.getTitle(),
                transactionRequest.getDescription(),
                transactionRequest.getAmount());
        TransactionResponse transactionResponse = new TransactionResponse(
                transactionDAO.updateTransaction(transactionUpdate, id));
        return transactionResponse;
    }

    @Override
    public void deleteTransaction(int id) {
        transactionDAO.deleteTransaction(id);
    }

    @Override
    public List<TransactionResponse> getTransaction() {
        List<TransactionResponse> transactionList = transactionDAO.getAllTransactions();
        List<TransactionResponse> transactionDTO = new ArrayList<>();

        for (TransactionResponse transaction : transactionList) {
            List<Integer> tagIds = transaction.getTagId();
            List<TagFinanceResponse> tagFinanceResponses = new ArrayList<>();

            for (int tagId : tagIds) {
                TagFinance tagFinance = tagFinanceDAO.getTagFinanceById(tagId);
                TagFinanceResponse tagFinanceResponse = new TagFinanceResponse(tagFinance.getName(), tagFinance.getDescription());
                tagFinanceResponses.add(tagFinanceResponse);
            }
            TransactionResponse transactionResponse = new TransactionResponse(
                    transaction.getId(),
                    transaction.getTitle(),
                    transaction.getDescription(),
                    transaction.getAmount(),
                    transaction.getTagId(),
                    tagFinanceResponses
            );
            transactionDTO.add(transactionResponse);
        }
        return transactionDTO;
    }


}
