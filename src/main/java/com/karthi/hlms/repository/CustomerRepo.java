package com.karthi.hlms.repository;

import com.karthi.hlms.model.Customer;

public interface CustomerRepo {
	public Customer save(Customer customer);

	public Customer findByName(String name);

	public Customer update(Customer customer);
}
