package com.karthi.hlms.repository;

import java.util.List;

import com.karthi.hlms.model.Loan;

public interface LoanRepo {

	Loan save(Loan loan);

	List<Loan> findAll();

	List<Loan> findByLoanCustomerId(Long customerId);

	Loan findById(Long id);
	
}
