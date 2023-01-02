package com.model;


public class Student {

	private int id;
	private String name;
	private String email;
	private int age;
	private String dept;
	public Student() {
	}
	public Student(String name, String email, int age, String dept) {
		this.name = name;
		this.email = email;
		this.age = age;
		this.dept = dept;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	
	
}
