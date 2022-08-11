package com.ab.dao;
import com.ab.model.Student;

public interface StudentDAO {
	public Student registerStudent(Student student);
	public String loginStudent(String email, String password);
}
