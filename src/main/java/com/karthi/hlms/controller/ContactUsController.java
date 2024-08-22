package com.karthi.hlms.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.karthi.hlms.model.ContactUs;
import com.karthi.hlms.serviceimpli.ContactUsServiceImpli;

@RestController
@RequestMapping("/contactus")
@CrossOrigin(origins = "http://localhost:3000/")
public class ContactUsController {
	ContactUsServiceImpli contactUsServiceImpli;

	public ContactUsController(ContactUsServiceImpli contactUsServiceImpli) {
		super();
		this.contactUsServiceImpli = contactUsServiceImpli;
	}

	@PostMapping("/request")
	public ContactUs createFeedback(@RequestBody ContactUs contactUs) {
		return contactUsServiceImpli.requestToAdmin(contactUs);
	}

	@GetMapping("/all")
	public List<ContactUs> getAllFeedbacks() {
		return contactUsServiceImpli.getAllFeedbacks();
	}
}
