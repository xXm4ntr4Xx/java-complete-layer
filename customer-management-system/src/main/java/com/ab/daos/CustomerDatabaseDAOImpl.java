package com.ab.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ab.models.Customer;
import com.ab.utilities.DatabaseConnection;

public class CustomerDatabaseDAOImpl implements CustomerDAO{
	
	
	private Connection con;
	
	private PreparedStatement pst;
	
	private ResultSet rs;
	
	

	@Override
	public Customer registerCustomer(Customer customer) {
		
		
		con = DatabaseConnection.getConnection();
		
		// Prepare a statement
		
		String query = "INSERT into customer(first_name, last_name, customer_email,customer_password) VALUES(?,?,?,?)";
		
		try {
			
				
			// Step 3
		pst = con.prepareStatement(query);
		
		// replace ?'s with actual customer data 
		
		pst.setString(1,customer.getFirstName());
		
		pst.setString(2, customer.getLastName());
		
		pst.setString(3, customer.getCustomerEmail());
		
		pst.setString(4, customer.getCustomerPassword());
		
		
		
		// Step 4
		
		// Here i indicates the number of records inserted/updated/deleted on a table
		int i = pst.executeUpdate(); // executeUpdate method is used to execute INSERT, UPDATE and DELETE command
		
		
		if(i > 0) {
			
			return customer;
		}
		
		
		}
		catch(SQLException e) {
			System.out.println(e);
			
		}
		
		
		return null;
		
		
	}

	@Override
	public String loginProcess(String customerEmail, String customerPassword) {
		
		String loginStatus = null;
		
		con = DatabaseConnection.getConnection();
		
		
		String query = "SELECT * from customer WHERE customer_email = ? AND customer_password = ?";
		
		try {
		pst = con.prepareStatement(query);
		
		
		// Replace ?'s with actual 
		pst.setString(1, customerEmail);
		
		pst.setString(2, customerPassword);
		
		
		
		rs = pst.executeQuery();
		
		if(rs.next()) {// If customer record found do this 
			loginStatus = "success";
		}
		else {
			loginStatus = "failure";
		}
		
		}
		catch(SQLException e) {
			
			System.out.println(e);
		}
		
		
		return loginStatus;
	}

	@Override
	public List<Customer> loadCustomers() {
		
		con = DatabaseConnection.getConnection();
		
		
		String query = "SELECT customer_id,first_name, last_name, customer_email from customer";
		
		
		try {
			
		
		pst = con.prepareStatement(query);
		
		
		rs = pst.executeQuery();
		
		
		
		List<Customer> cList = new ArrayList<>();
		
		
		
		while(rs.next()) {
			
			
			// Mapping all records into class object
			
			// Each and every record returned by SQL query will become an object 
			Customer c = new Customer(rs.getInt("customer_id"),
									  rs.getString("first_name"),
									  rs.getString("last_name"),
									  rs.getString("customer_email"));
			
			cList.add(c);
			
			
			
		}
		
		
		return cList;
		
		
	}
		catch(SQLException e) {
			System.out.println(e);
		}
		
		
		
		return null;
	}
	
	

}
