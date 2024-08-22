package com.karthi.hlms.repository;

import java.util.List;

import com.karthi.hlms.model.ContactUs;

public interface ContactUsRepo {

	void save(ContactUs contactUs);

	List<ContactUs> getAllFeedback();

}
