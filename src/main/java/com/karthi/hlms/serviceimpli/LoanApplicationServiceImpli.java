package com.karthi.hlms.serviceimpli;

import java.util.List;

import org.springframework.stereotype.Service;

import com.karthi.hlms.model.Customer;
import com.karthi.hlms.model.LoanApplication;
import com.karthi.hlms.repository.CustomerRepo;
import com.karthi.hlms.repository.LoanApplicationRepo;
import com.karthi.hlms.service.LoanApplicationService;

@Service
public class LoanApplicationServiceImpli implements LoanApplicationService{
	LoanApplicationRepo lRepo;
	CustomerRepo cRepo;

	public LoanApplicationServiceImpli(LoanApplicationRepo lRepo, CustomerRepo cRepo) {
		super();
		this.lRepo = lRepo;
		this.cRepo = cRepo;
	}

	@Override
	public LoanApplication applyLoan(LoanApplication LoanApplication) {
		return lRepo.save(LoanApplication);
	}

	public List<LoanApplication> getLoanApplicationsByCustomer(String customerName) {
		Customer customer = cRepo.findByName(customerName);
		return lRepo.findByBorrowerCustomer(customer);
	}

	public LoanApplication getLoanApplicationByLoanId(long loanid) {
		return lRepo.findById(loanid);
	}

	public List<LoanApplication> getLoanApplicationsByStatus(String status) {
		return lRepo.findByStatus(status);
	}

	public LoanApplication editStatus(long loanid, String status) {
		LoanApplication loanApplication = lRepo.findById(loanid);
		loanApplication.setStatus(status);
		return lRepo.updateApplicationByStatus(loanApplication);
	}

	public List<LoanApplication> getAlLoanApplications() {
		return lRepo.findAll();
	}
	
}
