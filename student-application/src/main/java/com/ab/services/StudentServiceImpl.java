package com.ab.services;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import com.ab.dao.StudentDAO;
import com.ab.model.Student;

public class StudentServiceImpl implements StudentService {
	private StudentDAO studentDAO;
	
	
	public StudentServiceImpl(StudentDAO studentDAO) {
		super();
		this.studentDAO = studentDAO;
	}

	@Override
	public Student registerStudent(Student student) {
		
		 /* Plain-text password initialization. */  
        String password = student.getPassword();  
        String encryptedpassword = null;  
        try{  
            /* MessageDigest instance for MD5. */  
            MessageDigest m = MessageDigest.getInstance("MD5");  
              
            /* Add plain-text password bytes to digest using MD5 update() method. */  
            m.update(password.getBytes());  
              
            /* Convert the hash value into bytes */   
            byte[] bytes = m.digest();  
              
            /* The bytes array has bytes in decimal form. Converting it into hexadecimal format. */  
            StringBuilder s = new StringBuilder();  
            for(int i=0; i< bytes.length ;i++)  
            {  
                s.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));  
            }    
            /* Complete hashed password in hexadecimal format */  
            encryptedpassword = s.toString();  
            Student std = new Student(student.getName(),student.getSurname(),student.getEmail(),encryptedpassword);
            return this.studentDAO.registerStudent(std);
        }   
        catch (NoSuchAlgorithmException e)   
        {  
            e.printStackTrace();  
        }  
		return null;
	}

	@Override
	public String loginStudent(String email, String password) {
		
  
        String encryptedpassword = null;  
        try{  
            /* MessageDigest instance for MD5. */  
            MessageDigest m = MessageDigest.getInstance("MD5");  
              
            /* Add plain-text password bytes to digest using MD5 update() method. */  
            m.update(password.getBytes());  
              
            /* Convert the hash value into bytes */   
            byte[] bytes = m.digest();  
              
            /* The bytes array has bytes in decimal form. Converting it into hexadecimal format. */  
            StringBuilder s = new StringBuilder();  
            for(int i=0; i< bytes.length ;i++)  
            {  
                s.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));  
            }    
            /* Complete hashed password in hexadecimal format */  
            encryptedpassword = s.toString();  
//            Student std = new Student(email,encryptedpassword);
            return this.studentDAO.loginStudent(email, encryptedpassword);
        }   
        catch (NoSuchAlgorithmException e)   
        {  
            e.printStackTrace();  
        }
		return null;  
		
	}

}
