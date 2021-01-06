package com.rest.wfm.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rest.wfm.entity.UserDetails;

@RestController
public class CommonRest {
	@Autowired
	private UserDetails user;

@PostMapping("/loginpage")
	public UserDetails login() {
	    return user;
	}


}
