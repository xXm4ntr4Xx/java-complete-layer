package com.ab.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ab.daos.CustomerDAO;
import com.ab.daos.CustomerDatabaseDAOImpl;
import com.ab.models.Customer;
import com.ab.services.CustomerService;
import com.ab.services.CustomerServiceImpl;

/**
 * Servlet implementation class CustomerRegistrationServlet
 * 
 * Servlets acts as a controller which communicates with Service layer
 */
@WebServlet("/CustomerRegistrationServlet")
public class CustomerRegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerRegistrationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		// Write to code to retrieve customer input
		
		
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		// Create a model object using the input values
		Customer customer = new Customer(firstName,lastName,email,password);
		
		CustomerDAO dao = new CustomerDatabaseDAOImpl();
		
		CustomerService customerService = new CustomerServiceImpl(dao);
		
		Customer registeredCustomer = customerService.registerCustomer(customer);
		
		if(registeredCustomer != null) {
			
			response.sendRedirect("register_success.jsp"); // JSP represents view
		}
		else {
			// Redirect the request to index page
			response.sendRedirect("index.jsp"); // JSP represents view
		}

	}

}
