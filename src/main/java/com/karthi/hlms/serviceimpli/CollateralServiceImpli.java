package com.karthi.hlms.serviceimpli;

import java.util.List;

import org.springframework.stereotype.Service;

import com.karthi.hlms.model.Collateral;
import com.karthi.hlms.model.LoanApplication;
import com.karthi.hlms.repository.CollateralRepo;
import com.karthi.hlms.repository.LoanApplicationRepo;
import com.karthi.hlms.service.CollateralService;

@Service
public class CollateralServiceImpli implements CollateralService {
	CollateralRepo cRepo;
	LoanApplicationRepo lRepo;
	
	public CollateralServiceImpli(CollateralRepo cRepo, LoanApplicationRepo lRepo) {
		super();
		this.cRepo = cRepo;
		this.lRepo = lRepo;
	}

	public void add(Collateral collateral, long loanid) {
		LoanApplication loanApplication = lRepo.findById(loanid);
		collateral.setLoanApplication(loanApplication);
		
		cRepo.save(collateral);
	}

	public List<Collateral> findByLoanId(int loanid) {
		return cRepo.findByLoanId(loanid);
	}
	
}
