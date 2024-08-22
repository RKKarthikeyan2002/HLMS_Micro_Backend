package com.karthi.hlms.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.karthi.hlms.model.Borrower;
import com.karthi.hlms.serviceimpli.BorrowerServiceImpli;

@RestController
@RequestMapping("/borrower")
@CrossOrigin(origins = "http://localhost:3000/")
public class BorrowerController {
	BorrowerServiceImpli borrowerServiceImpli;

	public BorrowerController(BorrowerServiceImpli borrowerServiceImpli) {
		super();
		this.borrowerServiceImpli = borrowerServiceImpli;
	}

	@PostMapping("/register")
	public Borrower createCustomer(@RequestBody Borrower borrower) {
		return borrowerServiceImpli.addBorrower(borrower);
	}
}
