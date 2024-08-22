package com.karthi.hlms.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Collateral {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String type;
	private String value;

	@ManyToOne(cascade = CascadeType.MERGE, targetEntity = LoanApplication.class)
	private LoanApplication loanApplication;

	public Collateral() {
		super();
	}

	public Collateral(Long id, String type, String value, LoanApplication loanApplication) {
		super();
		this.id = id;
		this.type = type;
		this.value = value;
		this.loanApplication = loanApplication;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public LoanApplication getLoanApplication() {
		return loanApplication;
	}

	public void setLoanApplication(LoanApplication loanApplication) {
		this.loanApplication = loanApplication;
	}
}
