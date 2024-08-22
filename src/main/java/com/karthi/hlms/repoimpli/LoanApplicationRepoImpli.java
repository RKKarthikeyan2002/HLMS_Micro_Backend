package com.karthi.hlms.repoimpli;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.karthi.hlms.model.Customer;
import com.karthi.hlms.model.LoanApplication;
import com.karthi.hlms.repository.LoanApplicationRepo;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class LoanApplicationRepoImpli implements LoanApplicationRepo{
	EntityManager eManager;
	
	LoanApplicationRepoImpli(EntityManager eManager) {
		super();
		this.eManager = eManager;
	}

	@Override
	public LoanApplication save(LoanApplication loanApplication) {
		eManager.persist(loanApplication);
		return loanApplication;
	}

	@Override
	public LoanApplication findById(long id) {
		return eManager.find(LoanApplication.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<LoanApplication> findByBorrowerCustomer(Customer customer) {
		String hql = "SELECT la FROM LoanApplication la WHERE la.borrower.customer = :customer and la.status <> 'Approved'";
		return eManager.createQuery(hql).setParameter("customer", customer).getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<LoanApplication> findByStatus(String status) {
		String hql = "SELECT la FROM LoanApplication la WHERE la.status = :status";
		return eManager.createQuery(hql).setParameter("status", status).getResultList();
	}

	@Override
	public LoanApplication updateApplicationByStatus(LoanApplication loanApplication) {
		return eManager.merge(loanApplication);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<LoanApplication> findAll() {
		String hql = "From LoanApplication ORDER BY id DESC";
		return eManager.createQuery(hql).getResultList();
	}
	
}
