package com.karthi.hlms.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.karthi.hlms.model.LoanApplication;
import com.karthi.hlms.serviceimpli.LoanApplicationServiceImpli;

@RestController
@RequestMapping("/loanappli")
@CrossOrigin(origins = "http://localhost:3000/")
public class LoanApplicationController {
	LoanApplicationServiceImpli loanApplicationServiceImpli;
	
	public LoanApplicationController(LoanApplicationServiceImpli loanApplicationServiceImpli) {
		super();
		this.loanApplicationServiceImpli = loanApplicationServiceImpli;
	}

	@PostMapping("/apply")
	public LoanApplication createCustomer(@RequestBody LoanApplication loanApplication) {
		return loanApplicationServiceImpli.applyLoan(loanApplication);
	}
	
	@PatchMapping("/application/{loanid}")
	public LoanApplication updateLoanApplicationStatus(@PathVariable long loanid, @RequestParam("status") String status) {
        return loanApplicationServiceImpli.editStatus(loanid, status);
    }

	@GetMapping("/applications/{customerName}")
	public List<LoanApplication> getLoanApplicationsByCustomer(@PathVariable String customerName) {
        return loanApplicationServiceImpli.getLoanApplicationsByCustomer(customerName);
    }
	
	@GetMapping("/application/{loanid}")
	public LoanApplication getLoanApplicationByLoanId(@PathVariable long loanid) {
        return loanApplicationServiceImpli.getLoanApplicationByLoanId(loanid);
    }
	
	@GetMapping("{status}")
	public List<LoanApplication> getPendingLoanApplication(@PathVariable String status) {
        return loanApplicationServiceImpli.getLoanApplicationsByStatus(status);
	}
	
	@GetMapping("/all")
	public List<LoanApplication> getAlLoanApplications() {
        return loanApplicationServiceImpli.getAlLoanApplications();
	}
}
