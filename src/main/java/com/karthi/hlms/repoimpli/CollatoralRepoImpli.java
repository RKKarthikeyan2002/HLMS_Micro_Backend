package com.karthi.hlms.repoimpli;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.karthi.hlms.model.Collateral;
import com.karthi.hlms.repository.CollateralRepo;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class CollatoralRepoImpli implements CollateralRepo {
	EntityManager eManager;

	public CollatoralRepoImpli(EntityManager eManager) {
		super();
		this.eManager = eManager;
	}

	@Override
	public void save(Collateral collateral) {
		eManager.persist(collateral);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Collateral> findByLoanId(int loanid) {
		String hql = "FROM Collateral c WHERE c.loanApplication.id = :loanid";
		return eManager.createQuery(hql).setParameter("loanid", loanid).getResultList();
	}
	
}
