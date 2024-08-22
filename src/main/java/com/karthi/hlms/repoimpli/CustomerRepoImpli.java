package com.karthi.hlms.repoimpli;

import org.springframework.stereotype.Repository;

import com.karthi.hlms.model.Customer;
import com.karthi.hlms.repository.CustomerRepo;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class CustomerRepoImpli implements CustomerRepo{
	EntityManager eManager;

	public CustomerRepoImpli(EntityManager eManager) {
		super();
		this.eManager = eManager;
	}

	@Override
	public Customer save(Customer customer) {
		eManager.persist(customer);
		return customer;
	}

	@Override
	public Customer findByName(String name) {
		String hql = "select c from Customer c where name = :name";
		return (Customer) eManager.createQuery(hql).setParameter("name", name).getSingleResult();
	}

	@Override
	public Customer update(Customer customer) {
		return eManager.merge(customer);
	}

}
