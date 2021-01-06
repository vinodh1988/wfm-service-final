package com.rest.wfm.services;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.wfm.entity.Employee;
import com.rest.wfm.entity.Mail;
import com.rest.wfm.entity.Softlock;
import com.rest.wfm.entity.Users;
import com.rest.wfm.repositories.EmployeeRepository;
import com.rest.wfm.repositories.SoftlockRepository;
import com.rest.wfm.repositories.UserDAO;
import com.rest.wfm.utilities.AlreadyRequestedException;

@Service
public class WorkforceService {

	@Autowired
	   UserSession session;
	
	@Autowired
	   EmployeeRepository repo;
	
	@Autowired
	   SoftlockRepository wrepo;
	
	@Autowired
	   UserDAO urepo;
	
	@Autowired
	   EmailService eservice;
	
	public List<Employee> getEmployee()
	{
		return  repo.getEmployees(session.getDetails().getUsername());
	}
	
	public List<Softlock> getLocks(){
		return wrepo.getLocks(session.getDetails().getUsername());
	}
	
	public List<Softlock> getInactiveLocks(){
		return wrepo.getLocksNotActive(session.getDetails().getUsername());
	}
	
	public List<Softlock> getManagerLocks(){
		return wrepo.getManagerLocksNotActive(session.getDetails().getUsername());
	}
	
	public List<Softlock> getAppovedLocks(){
		return wrepo.getApproved(session.getDetails().getUsername());
	}
	
	public void addSoftlinkRequest(Softlock sl)  throws AlreadyRequestedException{
		try {
		sl.setLastupdated(new Date(System.currentTimeMillis()));
		sl.setReqdate(new Date(System.currentTimeMillis()));
		
	   
	      Employee e=repo.findById(sl.getEmployee_id()).get();
	      Users c=urepo.getUserByUsername(session.getDetails().getUsername());
	      Users u=urepo.getUserByUsername(e.getManager());
	      Users u1=urepo.getUserByUsername(e.getWfm_manager());
	      
	      if(e.getLockstatus().equals("request_waiting"))
	    	   throw new AlreadyRequestedException();
	      wrepo.save(sl);
	      String content="A New Request is raised by "+c.getName()+" for "+
	    		  e.getName();
	      Mail m=new Mail(c.getEmail(),"New Soft Lock Request",
	      	content);
	      
	      Mail m2=new Mail(u.getEmail(),"New Soft Lock Request",
	  	      	content);
	      
	      Mail m3=new Mail(u1.getEmail(),"New Soft Lock Request",
	  	      	content);
	  	     
	  	     eservice.addMessage(m);
	  	     eservice.addMessage(m2);
	  	     eservice.addMessage(m3);
	      
	      
		}
		catch(AlreadyRequestedException e) {
			throw e;
		}
		catch(Exception e) {
			throw e;
		}
	    
	}
	
	public void updateSoftlinkRequest(Softlock sl)  throws AlreadyRequestedException{
		try {
	     if(session.getDetails().getUsertype().equals("manager") || session.getDetails().getUsertype().equals("adm"))
	    	 sl.setMgrlastupdate(new Date(System.currentTimeMillis()));
	    else {
	    if(sl.getStatus().equals("approved"))
	    	sl.setManagerstatus("awaiting_confirmation");
		sl.setLastupdated(new Date(System.currentTimeMillis()));
	    }
		
	   
	      Employee e=repo.findById(sl.getEmployee_id()).get();
	      Users c=urepo.getUserByUsername(sl.getManager());
	      Users u=urepo.getUserByUsername(e.getManager());
	      Users u1=urepo.getUserByUsername(e.getWfm_manager());
	      
	      wrepo.save(sl);
	      String content="Status updated to "+sl.getStatus()
	         +" by "+e.getWfm_manager()+" for "+
	    		  e.getName();
	      
	      Mail m=new Mail(c.getEmail(),"Soft Lock Status Uppdate",
	      	content);
	      
	      Mail m2=new Mail(u.getEmail(),"Soft Lock Status Update",
	  	      	content);
	      
	      Mail m3=new Mail(u1.getEmail(),"Soft Lock Status Update",
	  	      	content);
	      
	      if(sl.getStatus()=="approved")
	      {
	    	  Mail m4=new Mail(e.getEmail(),"Soft Lock Status Update",
	  	  	      	content);
	    	  eservice.addMessage(m4);
	      }
	  	     
	  	     eservice.addMessage(m);
	  	     eservice.addMessage(m2);
	  	     eservice.addMessage(m3);
	      
	      
		}
		
		catch(Exception e) {
			throw e;
		}
	    
	}

}
