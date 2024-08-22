package com.karthi.hlms.service;

import com.karthi.hlms.model.Customer;

public interface CustomerService {
	public Customer registerCustomer(Customer customer);
	
	public String login(Customer customer);
	
	public Customer editCustomer(Customer customer);
}
