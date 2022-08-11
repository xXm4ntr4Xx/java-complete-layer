package com.ab.model;

public class Student {
	Integer id;
	String name;
	String surname;
	String email;
	String password;
	
	
	public Student(String name, String surname, String email, String password) {
		super();
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.password = password;
	}


	//Constructor
	public Student(Integer id, String name, String surname, String email, String password) {
		super();
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.password = password;
	}
	
	
	public Student(String email, String password) {
		this.email = email;
		this.password = password;
	}


	public Integer getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getSurname() {
		return surname;
	}
	public String getEmail() {
		return email;
	}
	public String getPassword() {
		return password;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "Student [\nid=" + id + ", name=" + name + ", surname=" + surname + ", email=" + email + ", password="
				+ password + "\n]";
	}
	
	
	
}

