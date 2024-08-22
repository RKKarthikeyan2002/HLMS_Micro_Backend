package com.karthi.hlms.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.karthi.hlms.model.Collateral;
import com.karthi.hlms.serviceimpli.CollateralServiceImpli;

@RestController
@RequestMapping("/collateral")
@CrossOrigin(origins = "http://localhost:3000/")
public class CollateralController {
	CollateralServiceImpli collateralServiceImpli;
		
	public CollateralController(CollateralServiceImpli collateralServiceImpli) {
		super();
		this.collateralServiceImpli = collateralServiceImpli;
	}

	@PostMapping("/{loanid}")
	public String addCollatoral(@RequestBody Collateral collateral, @PathVariable int loanid) {

		collateralServiceImpli.add(collateral, loanid);

		return "Success";
	}
	
	@GetMapping("/{loanid}")
    public List<Collateral> getAllCollateralsByLoanId(@PathVariable int loanid) {
        return collateralServiceImpli.findByLoanId(loanid);
    }
}
