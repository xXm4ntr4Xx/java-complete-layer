package com.ab.services;

import java.util.List;

import com.ab.daos.CustomerDAO;
import com.ab.models.Customer;

/*
 * Service Layer hold business logic which indicates how data is managed
 * 
 * This layer can also hold some additional code that may send Email or SMS notification
 * 
 *  
 */



public class CustomerServiceImpl implements CustomerService{
	
	
	private CustomerDAO customerDAO; // Has-a relationship
	
	
	public CustomerServiceImpl(CustomerDAO customerDAO) {
		
		this.customerDAO = customerDAO;
	}
	
	

	@Override
	public Customer registerCustomer(Customer customer) {
		
		// Try to encrypt customer password before sending customer details to DAO 
		
		return this.customerDAO.registerCustomer(customer);
	}

	@Override
	public String loginProcess(String customerEmail, String customerPassword) {
		
		
		// Try to encrypt customer password before sending customer details to DAO
		
		return this.customerDAO.loginProcess(customerEmail, customerPassword);
	}

	@Override
	public List<Customer> loadCustomers() {
		
		// We may consider writing some code to filter out the records given by DAO layer
		return this.customerDAO.loadCustomers();
	}

}
