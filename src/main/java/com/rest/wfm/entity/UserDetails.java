package com.rest.wfm.entity;

import org.springframework.stereotype.Component;

@Component
public class UserDetails {
  private String username;
  private String usertype;
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getUsertype() {
	return usertype;
}
public void setUsertype(String usertype) {
	this.usertype = usertype;
}
  
  
  
}
