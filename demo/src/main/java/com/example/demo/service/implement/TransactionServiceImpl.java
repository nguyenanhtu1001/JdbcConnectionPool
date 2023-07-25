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

    @Override
    public TransactionResponse createTransaction(TransactionRequest transactionRequest) {
        Transaction transaction = new Transaction(
                transactionRequest.getTitle(),
                transactionRequest.getDescription(),
                transactionRequest.getAmount());
        List<Integer> tagIds = transactionRequest.getTagId();
        Transaction newTransaction = transactionDAO.createTransaction(transaction, tagIds);
        TransactionResponse transactionResponse = new TransactionResponse(transactionRequest, tagIds);

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

        List<TransactionResponse> transactions = transactionDAO.getAllTransactions();
        List<TransactionResponse> transactionResponses = new ArrayList<>();
        List<Integer> tagIds;
        List<TagFinanceResponse> tagFinanceResponses;
        TagFinanceResponse tagFinanceResponse;
        TransactionResponse transactionResponse;

        for (TransactionResponse transaction : transactions) {
            tagIds = transaction.getTagId();
            tagFinanceResponses = new ArrayList<>();

            for (int tagId : tagIds) {
                TagFinance tagFinance = tagFinanceDAO.getTagFinanceById(tagId);
                tagFinanceResponse = new TagFinanceResponse(tagFinance.getName(), tagFinance.getDescription());
                tagFinanceResponses.add(tagFinanceResponse);
            }
            transactionResponse = new TransactionResponse(
                    transaction.getId(),
                    transaction.getTitle(),
                    transaction.getDescription(),
                    transaction.getAmount(),
                    transaction.getTagId(),
                    tagFinanceResponses
            );
            transactionResponses.add(transactionResponse);
        }
        return transactionResponses;
    }

}
