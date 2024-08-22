package com.karthi.hlms.repository;

import java.util.List;

import com.karthi.hlms.model.Customer;
import com.karthi.hlms.model.LoanApplication;

public interface LoanApplicationRepo {
	public LoanApplication save(LoanApplication loanApplication);

	public LoanApplication findById(long id);

	public List<LoanApplication> findByBorrowerCustomer(Customer customer);

	public List<LoanApplication> findByStatus(String status);

	public LoanApplication updateApplicationByStatus(LoanApplication loanApplication);

	public List<LoanApplication> findAll();
}
