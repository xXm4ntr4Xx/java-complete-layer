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
 * Servlet implementation class CustomerLoginServlet
 */
@WebServlet("/CustomerLoginServlet")
public class CustomerLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerLoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		// Read User Input 
		
		String email = request.getParameter("customerEmail");
		String password = request.getParameter("customerPassword");
		
		
		CustomerDAO dao = new CustomerDatabaseDAOImpl();
		
		CustomerService customerService = new CustomerServiceImpl(dao);
		
		String status = customerService.loginProcess(email,password);
		
		
		if(status.equals("success")) {
			
			response.sendRedirect("dashboard.jsp");
		}
		else {
			
			response.sendRedirect("login_failure.jsp");
			
		}
		
		
		
		
		
	}

}
