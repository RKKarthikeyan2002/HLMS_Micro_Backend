package com.karthi.hlms.service;

import java.util.List;

import com.karthi.hlms.model.LoanApplication;

public interface LoanApplicationService {
	public LoanApplication applyLoan(LoanApplication loanApplication);
	
	public List<LoanApplication> getLoanApplicationsByCustomer(String customerName);
	
	public List<LoanApplication> getLoanApplicationsByStatus(String status);
	
	public List<LoanApplication> getAlLoanApplications();
}
