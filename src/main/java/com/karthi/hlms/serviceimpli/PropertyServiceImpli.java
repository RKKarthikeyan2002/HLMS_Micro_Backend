package com.karthi.hlms.serviceimpli;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.karthi.hlms.model.LoanApplication;
import com.karthi.hlms.model.Property;
import com.karthi.hlms.repository.LoanApplicationRepo;
import com.karthi.hlms.repository.PropertyRepo;
import com.karthi.hlms.service.PropertyService;

@Service
public class PropertyServiceImpli implements PropertyService {
	PropertyRepo pRepo;
	LoanApplicationRepo lRepo;
	
	public PropertyServiceImpli(PropertyRepo pRepo, LoanApplicationRepo lRepo) {
		super();
		this.pRepo = pRepo;
		this.lRepo = lRepo;
	}

	public void upload(MultipartFile file, String address, long id) throws IOException {
		if (file != null && !file.isEmpty()) {
			Property property = new Property();
			LoanApplication loanApplication = lRepo.findById(id);
			loanApplication.setStatus("Processing");
			LoanApplication loanApplication2 = lRepo.updateApplicationByStatus(loanApplication);
			
			property.setAddress(address);
			property.setFilename(file.getOriginalFilename());
			property.setFileType(file.getContentType());
			property.setData(file.getBytes());
			property.setLoanApplication(loanApplication2);

			pRepo.save(property);
		}
	}

	public List<Property> getPropertiesByLoanApplicationStatusInProgress() {
		return pRepo.findPropertiesByLoanApplicationStatusInProgress();
	}

	public Property getPropertyByLoanId(Long loanId) {
		return pRepo.findByLoanApplicationId(loanId);
	}
	
}
