package com.rest.wfm.services;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.rest.wfm.entity.Users;
import com.rest.wfm.repositories.UserDAO;


@Service(value="userDetailsService")
public class UserServiceImpl implements UserDetailsService {
	@Autowired
	 private UserSession session;
	@Autowired
	private UserDAO userDao;
   @Override
	public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
	System.out.println("this bean is called....!!!");
	Users user=null;
	try {
	   user = userDao.getUserByUsername(userId);
	}
	catch(Exception e) {
		e.printStackTrace();
	}
		
		if(user == null){
			System.out.println("user is null");
			throw new UsernameNotFoundException("Invalid username or password.");
		}
		else {
			System.out.println("user is read...!!!");
		}
		// System.out.println(user.getUsername());
		session.setSession(user.getUsername(),user.getRole());
		return new org.springframework.security.core.userdetails.User(user.getUsername(), new BCryptPasswordEncoder().encode(user.getPassword()), getAuthority(user));
	}

	private Collection<GrantedAuthority> getAuthority(Users user) {
		
		Collection<GrantedAuthority> c=new ArrayList<GrantedAuthority>();
		if(user.getRole().equals("wfm_member"))
		c.add(new SimpleGrantedAuthority("ROLE_WFM"));
		else
		c.add(new SimpleGrantedAuthority("ROLE_MANAGER"));
		return c;
	}

	
}