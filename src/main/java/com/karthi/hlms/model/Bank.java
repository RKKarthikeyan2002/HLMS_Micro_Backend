package com.karthi.hlms.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToOne;

@Entity
public class Bank {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private Long accountNo;
	private String ifsc;

	private String filename;
	private String fileType;
	@Lob
	@Column(length = 100000)
	private byte[] data;

	@OneToOne(cascade = CascadeType.MERGE, targetEntity = LoanApplication.class)
	private LoanApplication loanApplication;

	public Bank() {
		super();
	}

	public Bank(Long id, String name, Long accountNo, String ifsc, String filename, String fileType, byte[] data,
			LoanApplication loanApplication) {
		super();
		this.id = id;
		this.name = name;
		this.accountNo = accountNo;
		this.ifsc = ifsc;
		this.filename = filename;
		this.fileType = fileType;
		this.data = data;
		this.loanApplication = loanApplication;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(Long accountNo) {
		this.accountNo = accountNo;
	}

	public String getIfsc() {
		return ifsc;
	}

	public void setIfsc(String ifsc) {
		this.ifsc = ifsc;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public byte[] getData() {
		return data;
	}

	public void setData(byte[] data) {
		this.data = data;
	}

	public LoanApplication getLoanApplication() {
		return loanApplication;
	}

	public void setLoanApplication(LoanApplication loanApplication) {
		this.loanApplication = loanApplication;
	}
}
