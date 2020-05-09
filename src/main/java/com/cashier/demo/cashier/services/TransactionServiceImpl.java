package com.cashier.demo.cashier.services;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cashier.demo.cashier.models.Transaction;
import com.cashier.demo.cashier.repositories.TransactionRepository;

@Service
public class TransactionServiceImpl implements TransactionService {

	@Autowired
	private TransactionRepository transactionRepository;
	
	@Override
	public Map<String, Object> saveTransaction(Map<String, Object> data) {
		Map<String, Object> map= new HashMap<>();
		try {
			Transaction transaction= new Transaction();
			transaction.setType((String) data.get("type"));
			transaction.setAmount(data.get("amount").toString());
			transaction.setDescription((String) data.get("description"));
			transaction.setDate(new Date());
			transactionRepository.save(transaction);
			map.put("response", true);
		}catch(Exception ex) {
			map.put("response", false);
		}
		
		return map;
	}

	@Override
	public List<Transaction> getTransactions() {
		// TODO Auto-generated method stub
		return transactionRepository.getTransactionsOrderByDate();
	}

}
