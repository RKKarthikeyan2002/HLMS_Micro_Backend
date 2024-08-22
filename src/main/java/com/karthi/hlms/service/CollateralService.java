package com.karthi.hlms.service;

import java.util.List;

import com.karthi.hlms.model.Collateral;

public interface CollateralService {
	public void add(Collateral collateral, long loanid);
	
	public List<Collateral> findByLoanId(int loanid);
}
