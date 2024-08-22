package com.karthi.hlms.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.karthi.hlms.model.Customer;
import com.karthi.hlms.serviceimpli.CustomerServiceImpli;

@RestController
@RequestMapping("/customer")
@CrossOrigin(origins = "http://localhost:3000/")
public class CustomerController {
	CustomerServiceImpli customerServiceImpli;

	public CustomerController(CustomerServiceImpli customerServiceImpli) {
		this.customerServiceImpli = customerServiceImpli;
	}
	
	@GetMapping("{name}")
	public Customer getCustomer(@PathVariable String name) {
		return customerServiceImpli.getCustomerByName(name);
	}
	
	@PostMapping("/register")
	public Customer createCustomer(@RequestBody Customer customer) {
		return customerServiceImpli.registerCustomer(customer);
	}
	
	@PostMapping("/login")
    public String login(@RequestBody Customer customer) {
        return customerServiceImpli.login(customer);
    }
	
	@PutMapping("/update")
	public Customer updateCustomer(@RequestBody Customer customer) {
		return customerServiceImpli.editCustomer(customer);
	}
	
	@PutMapping("/update/{name}/password")
	public Customer updatePassword(@RequestParam("newPassword") String newPassword, @RequestParam("oldPassword") String oldPassword, @PathVariable String name) {
		return customerServiceImpli.editPassword(name, newPassword, oldPassword);
	}
}
