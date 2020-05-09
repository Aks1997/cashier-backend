package com.cashier.demo.cashier.services;

import java.util.List;
import java.util.Map;

import com.cashier.demo.cashier.models.Transaction;

public interface TransactionService {
	public Map<String, Object> saveTransaction(Map<String, Object> data);
	public List<Transaction> getTransactions();
}
