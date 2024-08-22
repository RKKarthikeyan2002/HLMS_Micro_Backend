package com.karthi.hlms.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.karthi.hlms.model.Document;
import com.karthi.hlms.serviceimpli.DocumentServiceImpli;

@RestController
@RequestMapping("/document")
@CrossOrigin(origins = "http://localhost:3000/")
public class DocumentsController {
	DocumentServiceImpli documentServiceImpli;

	public DocumentsController(DocumentServiceImpli documentServiceImpli) {
		super();
		this.documentServiceImpli = documentServiceImpli;
	}

	@PostMapping("/upload")
	public String handleFileUpload(@RequestParam("aadhar") MultipartFile aadhar,
			@RequestParam("pancard") MultipartFile pancard, @RequestParam("photo") MultipartFile photo,
			@RequestParam("appliid") long id) {

		try {
			documentServiceImpli.upload(aadhar, id);
			documentServiceImpli.upload(pancard, id);
			documentServiceImpli.upload(photo, id);
		} catch (IOException e) {
			return "Fail";
		}

		return "Success";
	}
	
	@PostMapping("/upload/irt")
	public String handleItrUpload(@RequestParam("itrfile") MultipartFile itr, @RequestParam("loanId") long id) {

		try {
			documentServiceImpli.upload(itr, id);
		} catch (IOException e) {
			return "Fail";
		}

		return "Success";
	}
	
	@GetMapping("/files/{loanApplicationId}")
    public List<Document> getDocumentsByLoanApplicationId(@PathVariable Long loanApplicationId) {
        return documentServiceImpli.getDocumentsByLoanApplicationId(loanApplicationId);
    }
}
