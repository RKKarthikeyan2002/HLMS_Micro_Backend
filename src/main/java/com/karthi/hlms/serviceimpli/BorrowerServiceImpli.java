package com.karthi.hlms.serviceimpli;

import org.springframework.stereotype.Service;

import com.karthi.hlms.model.Borrower;
import com.karthi.hlms.repository.BorrowerRepo;
import com.karthi.hlms.service.BorrowerService;

@Service
public class BorrowerServiceImpli implements BorrowerService {
	BorrowerRepo bRepo;
	
	public BorrowerServiceImpli(BorrowerRepo bRepo) {
		super();
		this.bRepo = bRepo;
	}

	@Override
	public Borrower addBorrower(Borrower borrower) {
		return bRepo.save(borrower);
	}

}
