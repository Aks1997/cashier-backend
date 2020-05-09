package com.cashier.demo.cashier.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cashier.demo.cashier.models.Transaction;
import com.cashier.demo.cashier.services.TransactionService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/transaction")
public class TransactionController {

	@Autowired
	private TransactionService transactionServiceImpl;
	
	@RequestMapping(value="/save", method= RequestMethod.POST)
	@ResponseBody
	private ResponseEntity<Map<String, Object>> saveTransaction(@RequestBody Map<String, Object> data){
		Map<String, Object> result= transactionServiceImpl.saveTransaction(data);
		return new ResponseEntity<Map<String, Object>>(result, HttpStatus.OK);
	}
	
	@RequestMapping(value="/fetch", method= RequestMethod.GET)
	@ResponseBody
	private ResponseEntity<List<Transaction>> getTransactions(){
		List<Transaction> result= transactionServiceImpl.getTransactions();
		return new ResponseEntity<List<Transaction>>(result, HttpStatus.OK);
	}
}
