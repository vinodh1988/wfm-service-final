package com.rest.wfm.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table
public class Users {
  @Id
  private String username;
  @Column
  private String name;
  @Column
  @JsonIgnore
  private String password;
  @Column
  private String role;
  @Column
  private String email;
  
  
public Users() {
	super();
	// TODO Auto-generated constructor stub
}


public Users(String username, String name, String password, String role) {
	super();
	this.username = username;
	this.name = name;
	this.password = password;
	this.role = role;
}


public String getUsername() {
	return username;
}


public void setUsername(String username) {
	this.username = username;
}


public String getEmail() {
	return email;
}


public void setEmail(String email) {
	this.email = email;
}


public String getName() {
	return name;
}


public void setName(String name) {
	this.name = name;
}


public String getPassword() {
	return password;
}


public void setPassword(String password) {
	this.password = password;
}


public String getRole() {
	return role;
}


public void setRole(String role) {
	this.role = role;
}
  

  
}
