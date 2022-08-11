package com.ab.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ab.daos.CustomerDAO;
import com.ab.daos.CustomerDatabaseDAOImpl;
import com.ab.models.Customer;
import com.ab.services.CustomerService;
import com.ab.services.CustomerServiceImpl;

/**
 * Servlet implementation class LoadCustomersServlet
 */
@WebServlet("/LoadCustomersServlet")
public class LoadCustomersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoadCustomersServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		CustomerDAO dao = new CustomerDatabaseDAOImpl();
		
		CustomerService customerService = new CustomerServiceImpl(dao);
		
		List<Customer> customerList = customerService.loadCustomers();
		
		// Create a session object
		
		HttpSession session = request.getSession(true);
		
		
		// Now we can store the above List of customers in the session 
		
		session.setAttribute("cList", customerList);
		
		
		response.sendRedirect("view_customers.jsp");
		
		
		
		
		
		
		
	}

}
