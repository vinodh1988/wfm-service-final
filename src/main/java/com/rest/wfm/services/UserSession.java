package com.rest.wfm.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import com.rest.wfm.entity.UserDetails;

@Component
@SessionScope(proxyMode =ScopedProxyMode.TARGET_CLASS)
public class UserSession {
@Autowired
private UserDetails user;
	 public void setSession(String name,String usertype) {
		 user.setUsername(name);
		 user.setUsertype(usertype);
	 }
	 
	 public UserDetails getDetails() {
		 return user;
	 }
	 
	 
}
