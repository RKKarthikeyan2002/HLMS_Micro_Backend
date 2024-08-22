package com.karthi.hlms.repoimpli;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.karthi.hlms.model.Property;
import com.karthi.hlms.repository.PropertyRepo;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class PropertyRepoImpli implements PropertyRepo {
	EntityManager eManager;

	public PropertyRepoImpli(EntityManager eManager) {
		super();
		this.eManager = eManager;
	}

	@Override
	public void save(Property property) {
		eManager.persist(property);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Property> findPropertiesByLoanApplicationStatusInProgress() {
		String hql = "SELECT p FROM Property p WHERE p.loanApplication.status = 'Processing'";
		return eManager.createQuery(hql).getResultList();
	}

	@Override
	public Property findByLoanApplicationId(Long loanId) {
		String hql = "SELECT p FROM Property p WHERE p.loanApplication.id = :loanId";
		return (Property) eManager.createQuery(hql).setParameter("loanId", loanId).getSingleResult();
	}
	
}
