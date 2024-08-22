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

import com.karthi.hlms.model.Property;
import com.karthi.hlms.serviceimpli.PropertyServiceImpli;

@RestController
@RequestMapping("/property")
@CrossOrigin(origins = "http://localhost:3000/")
public class PropertyController {
	PropertyServiceImpli propertyServiceImpli;

	public PropertyController(PropertyServiceImpli propertyServiceImpli) {
		super();
		this.propertyServiceImpli = propertyServiceImpli;
	}
	
	@PostMapping("/upload")
	public String handleFileUpload(@RequestParam("propertyFile") MultipartFile property, @RequestParam("address") String address, @RequestParam("loanId") long id) throws IOException {

		propertyServiceImpli.upload(property, address, id);

		return "Success";
	}
	
	@GetMapping("/all/inProgress")
	public List<Property> getPropertiesByLoanApplicationStatusInProcess() {
		return propertyServiceImpli.getPropertiesByLoanApplicationStatusInProgress();
	}
	
	@GetMapping("/{loanId}")
	public Property getPropertyByLoanId(@PathVariable Long loanId) {
		return propertyServiceImpli.getPropertyByLoanId(loanId);
	}
}
