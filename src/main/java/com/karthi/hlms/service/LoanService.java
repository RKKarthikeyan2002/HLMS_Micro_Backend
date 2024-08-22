package com.karthi.hlms.service;

import java.util.List;

import com.karthi.hlms.model.Loan;

public interface LoanService {
	public Loan createLoan(Loan loan, Long loanid);
	
	public List<Loan> getAllLoans();
	
	public List<Loan> getLoansByCustomerId(Long customerId);
	
	public Loan getLoanById(Long id);
}
