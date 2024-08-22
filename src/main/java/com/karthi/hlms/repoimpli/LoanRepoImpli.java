package com.karthi.hlms.repoimpli;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.karthi.hlms.model.Loan;
import com.karthi.hlms.repository.LoanRepo;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class LoanRepoImpli implements LoanRepo{
	EntityManager eManager;

	public LoanRepoImpli(EntityManager eManager) {
		super();
		this.eManager = eManager;
	}

	@Override
	public Loan save(Loan loan) {
		eManager.persist(loan);
		return loan;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Loan> findAll() {
		String hql = "from Loan";
		return eManager.createQuery(hql).getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Loan> findByLoanCustomerId(Long customerId) {
		String hql = "SELECT l FROM Loan l JOIN l.loanApplication la WHERE la.borrower.customer.id = :customerId";
		return eManager.createQuery(hql).setParameter("customerId", customerId).getResultList();
	}

	@Override
	public Loan findById(Long id) {
		return eManager.find(Loan.class, id);
	}
}
