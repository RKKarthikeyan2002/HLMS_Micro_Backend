package com.karthi.hlms.serviceimpli;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.karthi.hlms.model.Customer;
import com.karthi.hlms.principle.CustomerPrincipal;
import com.karthi.hlms.repository.CustomerRepo;

@Service
public class MyUserDetailsService implements UserDetailsService {

	private final CustomerRepo cRepo;

	public MyUserDetailsService(CustomerRepo cRepo) {
		this.cRepo = cRepo;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Customer customer = cRepo.findByName(username);
		if (customer == null) {
			System.err.println("User Not Found");
			throw new UsernameNotFoundException("user not found");
		}

		return new CustomerPrincipal(customer);
	}
}
