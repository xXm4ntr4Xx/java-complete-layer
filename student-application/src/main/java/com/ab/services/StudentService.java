package com.ab.services;

import com.ab.model.Student;

public interface StudentService {
	public Student registerStudent(Student student);
	public String loginStudent(String email, String password);
}
