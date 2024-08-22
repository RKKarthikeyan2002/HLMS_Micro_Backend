package com.karthi.hlms.repoimpli;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.karthi.hlms.model.Document;
import com.karthi.hlms.repository.DocumentRepo;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class DocumentRepoImpli implements DocumentRepo {
	
	EntityManager eManager;
	
	public DocumentRepoImpli(EntityManager eManager) {
		super();
		this.eManager = eManager;
	}

	@Override
	public void save(Document document) {
		eManager.persist(document);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Document> findByLoanApplicationId(Long loanApplicationId) {
		String hql = "SELECT d FROM Document d WHERE d.loanApplication.id = :loanApplicationId";
		return eManager.createQuery(hql).setParameter("loanApplicationId", loanApplicationId).getResultList();
	}

}
