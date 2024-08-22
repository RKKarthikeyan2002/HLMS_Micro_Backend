package com.karthi.hlms.repository;

import java.util.List;

import com.karthi.hlms.model.Collateral;

public interface CollateralRepo {

	void save(Collateral collateral);

	List<Collateral> findByLoanId(int loanid);

}
