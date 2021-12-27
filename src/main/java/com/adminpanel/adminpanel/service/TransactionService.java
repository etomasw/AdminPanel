package com.adminpanel.adminpanel.service;

import com.adminpanel.adminpanel.model.Transaction;

import java.util.List;

public interface TransactionService {
    Transaction saveTransaction(Transaction transaction);

    Long numberOfTransactions();

    List<Transaction> findAllTransactions();
}
