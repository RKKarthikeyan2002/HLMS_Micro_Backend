package com.karthi.hlms.repoimpli;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.karthi.hlms.model.ContactUs;
import com.karthi.hlms.repository.ContactUsRepo;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class ContactUsRepoImpli implements ContactUsRepo {
	EntityManager eManager;
	
	public ContactUsRepoImpli(EntityManager eManager) {
		super();
		this.eManager = eManager;
	}

	@Override
	public void save(ContactUs contactUs) {
		eManager.persist(contactUs);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ContactUs> getAllFeedback() {
		String hql = "from ContactUs";
		return eManager.createQuery(hql).getResultList();
	}

}
