package com.karthi.hlms.repoimpli;

import org.springframework.stereotype.Repository;

import com.karthi.hlms.model.Borrower;
import com.karthi.hlms.repository.BorrowerRepo;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class BorrowerRepoImpli implements BorrowerRepo {
	EntityManager eManager;

	public BorrowerRepoImpli(EntityManager eManager) {
		super();
		this.eManager = eManager;
	}

	@Override
	public Borrower save(Borrower borrower) {
		eManager.persist(borrower);
		return borrower;
	}

}
