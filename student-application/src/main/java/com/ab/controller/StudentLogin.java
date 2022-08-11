package com.ab.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ab.dao.StudentDAO;
import com.ab.dao.StudentDAOImpl;
import com.ab.services.StudentService;
import com.ab.services.StudentServiceImpl;

/**
 * Servlet implementation class StudentLogin
 */
@WebServlet("/StudentLogin")
public class StudentLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public StudentLogin() {
        super();  
    }

	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	String email = request.getParameter("email");
	String password = request.getParameter("password");
	
	StudentDAO dao = new  StudentDAOImpl();
	StudentService sts = new StudentServiceImpl(dao);
	String status = sts.loginStudent(email, password);
	
	
	if(status.equals("success")) {
		response.sendRedirect("success.jsp");
	}else {
		response.sendRedirect("fail.jsp");
	}
	}

}
