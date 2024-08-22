package com.karthi.hlms.service;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.karthi.hlms.model.Document;

public interface DocumentService {
	public void upload(MultipartFile file, long id) throws IOException;
	
	public List<Document> getDocumentsByLoanApplicationId(Long loanApplicationId);
}
