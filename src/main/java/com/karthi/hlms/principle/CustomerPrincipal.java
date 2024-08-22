package com.karthi.hlms.principle;

import java.util.Collection;
import java.util.Collections;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.karthi.hlms.model.Customer;

@SuppressWarnings("serial")
public class CustomerPrincipal implements UserDetails {
	
	private Customer customer;
	
	public CustomerPrincipal(Customer customer) {
		this.customer = customer;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return Collections.singleton(new SimpleGrantedAuthority("Customer"));
	}

	@Override
	public String getPassword() {
		return customer.getPassword();
	}

	@Override
	public String getUsername() {
		return customer.getName();
	}
}
