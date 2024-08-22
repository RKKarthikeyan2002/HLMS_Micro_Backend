package com.karthi.hlms.service;

import java.util.List;

import com.karthi.hlms.model.ContactUs;

public interface ContactUsService {
	public ContactUs requestToAdmin(ContactUs contactUs);
	
	public List<ContactUs> getAllFeedbacks();
}
