package com.ab.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ab.model.Student;
import com.ab.utilities.DatabaseConnection;


public class StudentDAOImpl implements StudentDAO {

	private Connection con;
	private PreparedStatement pst;
	private ResultSet res;

	
	@Override
	public Student registerStudent(Student student) {
		con=DatabaseConnection.getConnection();
		String query = "INSERT INTO student (name,surname,email,password) VALUES(?,?,?,?)";

		try {
			pst= con.prepareStatement(query);
			
			pst.setString(1, student.getName());
			pst.setString(2, student.getSurname());
			pst.setString(3, student.getEmail());
			pst.setString(4, student.getPassword());
			
			int value = pst.executeUpdate();
			System.out.println(student);
			System.out.println(value);
			if(value>0) {
				return student;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public String loginStudent(String email, String password) {
		String loginStatus=null;
		
		con=DatabaseConnection.getConnection();
		String query = "SELECT * FROM student WHERE email = ? AND password = ?";
		try {
			pst = con.prepareStatement(query);
			//replace the ? with email and password details
			pst.setString(1, email);
			pst.setString(2, password);
			
			res=pst.executeQuery();
			
			if(res.next()) {
				loginStatus = "success";
			}else {
				loginStatus = "failure";
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return loginStatus;
	}

}
