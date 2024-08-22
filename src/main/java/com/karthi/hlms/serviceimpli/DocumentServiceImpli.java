package com.karthi.hlms.serviceimpli;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.karthi.hlms.model.Document;
import com.karthi.hlms.model.LoanApplication;
import com.karthi.hlms.repository.DocumentRepo;
import com.karthi.hlms.repository.LoanApplicationRepo;
import com.karthi.hlms.service.DocumentService;

@Service
public class DocumentServiceImpli implements DocumentService {
	DocumentRepo dRepo;
	LoanApplicationRepo lRepo;

	public DocumentServiceImpli(DocumentRepo dRepo, LoanApplicationRepo lRepo) {
		super();
		this.dRepo = dRepo;
		this.lRepo = lRepo;
	}

	public void upload(MultipartFile file, long id) throws IOException {
		if (file != null && !file.isEmpty()) {
			Document document = new Document();
			LoanApplication loanApplication = lRepo.findById(id);

			document.setFilename(file.getOriginalFilename());
			document.setFileType(file.getContentType());
			document.setData(file.getBytes());
			document.setLoanApplication(loanApplication);

			dRepo.save(document);
		}
	}

	public List<Document> getDocumentsByLoanApplicationId(Long loanApplicationId) {
		return dRepo.findByLoanApplicationId(loanApplicationId);
	}

}
