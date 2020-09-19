package com.microservicefullProject.dto;

public class UserToTestRestTemplate {
	
	private long id;
	private String name;
	private String email; 
	private String pwd;
	public long getId() {
		return id;
	}
	public void setId(long id) {
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
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	@Override
	public String toString() {
		return "UserToTestRestTemplate [id=" + id + ", name=" + name + ", email=" + email + ", pwd=" + pwd + "]";
	}
	
	
	

}
