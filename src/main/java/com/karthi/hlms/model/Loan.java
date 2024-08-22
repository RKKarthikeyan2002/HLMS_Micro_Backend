package com.karthi.hlms.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Loan {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private double amount;
	private String type;
	private double interest;
	private int termMonths;

	@ManyToOne(cascade = CascadeType.MERGE, targetEntity = LoanApplication.class)
	private LoanApplication loanApplication;

	public Loan() {
		super();
	}

	public Loan(Long id, double amount, String type, double interest, int termMonths, LoanApplication loanApplication) {
		super();
		this.id = id;
		this.amount = amount;
		this.type = type;
		this.interest = interest;
		this.termMonths = termMonths;
		this.loanApplication = loanApplication;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getInterest() {
		return interest;
	}

	public void setInterest(double interest) {
		this.interest = interest;
	}

	public int getTermMonths() {
		return termMonths;
	}

	public void setTermMonths(int termMonths) {
		this.termMonths = termMonths;
	}

	public LoanApplication getLoanApplication() {
		return loanApplication;
	}

	public void setLoanApplication(LoanApplication loanApplication) {
		this.loanApplication = loanApplication;
	}
}
