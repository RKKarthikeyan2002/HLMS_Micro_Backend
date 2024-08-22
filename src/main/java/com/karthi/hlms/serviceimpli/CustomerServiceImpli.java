package com.karthi.hlms.serviceimpli;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.karthi.hlms.model.Customer;
import com.karthi.hlms.repository.CustomerRepo;
import com.karthi.hlms.service.CustomerService;

@Service
public class CustomerServiceImpli implements CustomerService {
	CustomerRepo cRepo;

	@Autowired
	private JWTService jwtService;

	@Autowired
	AuthenticationManager authManager;

	private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

	public CustomerServiceImpli(CustomerRepo cRepo) {
		super();
		this.cRepo = cRepo;
	}

	@Override
	public Customer registerCustomer(Customer customer) {
		customer.setPassword(encoder.encode(customer.getPassword()));
		return cRepo.save(customer);
	}

	public String login(Customer c) {
		Customer customer = cRepo.findByName(c.getName());
		if (customer != null && encoder.matches(c.getPassword(), customer.getPassword())) {
			return jwtService.generateToken(customer);
		} else {
			return "";
		}
	}

	public Customer getCustomerByName(String name) {
		return cRepo.findByName(name);
	}

	public Customer editCustomer(Customer c) {
		Customer customer = cRepo.findByName(c.getName());
		customer.setAge(c.getAge());
		customer.setDob(c.getDob());
		customer.setAddress(c.getAddress());
		customer.setPhone(c.getPhone());
		return cRepo.update(customer);
	}

	public Customer editPassword(String name, String newPassword, String oldPassword) {
		Customer customer = cRepo.findByName(name);
		if(encoder.matches(oldPassword, customer.getPassword())) {
			customer.setPassword(encoder.encode(newPassword));
			return cRepo.update(customer);
		}
		return null;
	}
}
