package com.karthi.hlms.repository;

import java.util.List;

import com.karthi.hlms.model.Document;

public interface DocumentRepo {

	void save(Document document);

	List<Document> findByLoanApplicationId(Long loanApplicationId);

}
