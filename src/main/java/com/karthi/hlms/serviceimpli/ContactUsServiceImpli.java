package com.karthi.hlms.serviceimpli;

import java.util.List;

import org.springframework.stereotype.Service;

import com.karthi.hlms.model.ContactUs;
import com.karthi.hlms.repository.ContactUsRepo;
import com.karthi.hlms.service.ContactUsService;

@Service
public class ContactUsServiceImpli implements ContactUsService {
	ContactUsRepo cUsRepo;
		
	public ContactUsServiceImpli(ContactUsRepo cUsRepo) {
		super();
		this.cUsRepo = cUsRepo;
	}

	public ContactUs requestToAdmin(ContactUs contactUs) {
		cUsRepo.save(contactUs);
		return contactUs;
	}

	public List<ContactUs> getAllFeedbacks() {
		return cUsRepo.getAllFeedback();
	}

}
