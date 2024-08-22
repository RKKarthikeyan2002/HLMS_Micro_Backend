package com.karthi.hlms.repository;

import java.util.List;

import com.karthi.hlms.model.Property;

public interface PropertyRepo {

	void save(Property property);

	List<Property> findPropertiesByLoanApplicationStatusInProgress();

	Property findByLoanApplicationId(Long loanId);

}
