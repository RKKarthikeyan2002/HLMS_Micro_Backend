package com.karthi.hlms.service;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.karthi.hlms.model.Property;

public interface PropertyService {
	public void upload(MultipartFile file, String address, long id) throws IOException;
	
	public Property getPropertyByLoanId(Long loanId);
	
	public List<Property> getPropertiesByLoanApplicationStatusInProgress();
}
