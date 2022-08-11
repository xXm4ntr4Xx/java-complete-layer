package com.ab.services;

import java.util.List;

import com.ab.models.Customer;

public interface CustomerService {
	
	
	public Customer registerCustomer(Customer customer);
	
	public String loginProcess(String customerEmail, String customerPassword);
	
	public List<Customer> loadCustomers();
	

}
