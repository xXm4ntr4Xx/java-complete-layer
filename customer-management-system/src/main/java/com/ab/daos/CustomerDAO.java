package com.ab.daos;

import java.util.List;

import com.ab.models.Customer;

public interface CustomerDAO {

	// Abstract methods
	
	public Customer registerCustomer(Customer customer);
	
	public String loginProcess(String customerEmail, String customerPassword);
	
	public List<Customer> loadCustomers();
	
	
}
