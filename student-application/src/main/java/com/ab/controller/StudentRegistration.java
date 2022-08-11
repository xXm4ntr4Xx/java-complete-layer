package com.ab.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ab.dao.StudentDAO;
import com.ab.dao.StudentDAOImpl;
import com.ab.model.Student;
import com.ab.services.StudentService;
import com.ab.services.StudentServiceImpl;

/**
 * Servlet implementation class StudentRegistration
 */
@WebServlet("/StudentRegistration")
public class StudentRegistration extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public StudentRegistration() {
        super(); 
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String surname = request.getParameter("surname");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		Student student = new Student(name,surname,email,password);
		
		StudentDAO stDAO =  new StudentDAOImpl();
		
		StudentService std = new StudentServiceImpl(stDAO);
		
		Student registeredStudent = std.registerStudent(student);
		
		if(registeredStudent!=null) {
			response.sendRedirect("success.jsp");
		}else {
			response.sendRedirect("fail.jsp");
		}
	}

}
