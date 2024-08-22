package com.karthi.hlms.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.karthi.hlms.model.Loan;
import com.karthi.hlms.serviceimpli.LoanServiceImpli;

@RestController
@RequestMapping("/loan")
@CrossOrigin(origins = "http://localhost:3000/")
public class LoanController {
	LoanServiceImpli loanServiceImpli;

	public LoanController(LoanServiceImpli loanServiceImpli) {
		super();
		this.loanServiceImpli = loanServiceImpli;
	}
	
	@PostMapping("{loanId}")
    public Loan createLoan(@RequestBody Loan loan, @PathVariable Long loanId ) {
        return loanServiceImpli.createLoan(loan, loanId);
    }
	
	@GetMapping("/all")
    public List<Loan> getAllLoans() {
        return loanServiceImpli.getAllLoans();
    }
	
	@GetMapping("{id}")
    public Loan getLoanById(@PathVariable Long id) {
        return loanServiceImpli.getLoanById(id);
    }
	
	@GetMapping("/applications/{customerId}")
    public List<Loan> getLoansByCustomerId(@PathVariable Long customerId) {
        return loanServiceImpli.getLoansByCustomerId(customerId);
    }

}
