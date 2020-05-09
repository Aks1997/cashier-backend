package com.cashier.demo.cashier.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cashier.demo.cashier.models.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

	@Query("FROM Transaction trans order by trans.date asc")
	public List<Transaction> getTransactionsOrderByDate();
}
