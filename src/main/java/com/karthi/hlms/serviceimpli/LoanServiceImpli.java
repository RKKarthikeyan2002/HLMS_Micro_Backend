package com.karthi.hlms.serviceimpli;

import java.util.List;

import org.springframework.stereotype.Service;

import com.karthi.hlms.model.Loan;
import com.karthi.hlms.model.LoanApplication;
import com.karthi.hlms.repository.LoanApplicationRepo;
import com.karthi.hlms.repository.LoanRepo;
import com.karthi.hlms.service.LoanService;

@Service
public class LoanServiceImpli implements LoanService {
	LoanRepo lRepo;
	LoanApplicationRepo lApplicationRepo;
	
	public LoanServiceImpli(LoanRepo lRepo, LoanApplicationRepo lApplicationRepo) {
		super();
		this.lRepo = lRepo;
		this.lApplicationRepo = lApplicationRepo;
	}

	public Loan createLoan(Loan loan, Long loanid) {
		LoanApplication loanApplication = lApplicationRepo.findById(loanid);
		loan.setLoanApplication(loanApplication);
		return lRepo.save(loan);
	}

	public List<Loan> getAllLoans() {
		return lRepo.findAll();
	}

	public List<Loan> getLoansByCustomerId(Long customerId) {
		return lRepo.findByLoanCustomerId(customerId);
	}

	public Loan getLoanById(Long id) {
		return lRepo.findById(id);
	}

}
