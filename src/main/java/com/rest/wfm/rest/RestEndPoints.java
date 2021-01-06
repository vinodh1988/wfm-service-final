package com.rest.wfm.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rest.wfm.entity.Employee;
import com.rest.wfm.entity.Softlock;
import com.rest.wfm.services.WorkforceService;
import com.rest.wfm.utilities.AlreadyRequestedException;

@RestController
@RequestMapping("/endpoints")
public class RestEndPoints {
	
	
	
	@Autowired
	private WorkforceService wservice;

	 @GetMapping("/home")
	 public String home() {
	
		 return "home functionality";
	 }
	 
	 @GetMapping("/employees")
	 public ResponseEntity<List<Employee>> getEmp(){
		 return new ResponseEntity<List<Employee>>(wservice.getEmployee(),HttpStatus.OK);
	 }
	 
	 @GetMapping("/waiting-locks")
	 public ResponseEntity<List<Softlock>> getLocks(){
		 return new ResponseEntity<List<Softlock>>(wservice.getLocks(),HttpStatus.OK);
	 }
	 
	 @GetMapping("/inactive-locks")
	 public ResponseEntity<List<Softlock>> getInactiveLocks(){
		 return new ResponseEntity<List<Softlock>>(wservice.getInactiveLocks(),HttpStatus.OK);
	 }
	
	 @GetMapping("/manager-locks")
	 public ResponseEntity<List<Softlock>> getManagerLocks(){
		 return new ResponseEntity<List<Softlock>>(wservice.getManagerLocks(),HttpStatus.OK);
	 }
	
	 @GetMapping("/approved-locks")
	 public ResponseEntity<List<Softlock>> getApprovedLocks(){
		 return new ResponseEntity<List<Softlock>>(wservice.getAppovedLocks(),HttpStatus.OK);
	 }
	
	
	 @PostMapping("/softlock")
	 public ResponseEntity<String> addSoftlock(@RequestBody Softlock softlock)
	 {
		 try {
			 softlock.setStatus("waiting");
			 //softlock.setManagerstatus("awaiting_approval");
			 wservice.addSoftlinkRequest(softlock);
			 return new ResponseEntity<String>("Request Sent",HttpStatus.CREATED);
		 }
		 catch(AlreadyRequestedException e) {
			 return new ResponseEntity<String>("Already_locked",HttpStatus.ALREADY_REPORTED);
		 }
		 catch(Exception e) {
			 e.printStackTrace();
			 return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
			 
		 }
	 }
	 
	 @PutMapping("/softlock")
	 public ResponseEntity<String> updateSoftlock(@RequestBody Softlock softlock)
	 {
		 try {
			 
			 wservice.updateSoftlinkRequest(softlock);
			 return new ResponseEntity<String>("Request Sent",HttpStatus.CREATED);
		 }
		 catch(AlreadyRequestedException e) {
			 return new ResponseEntity<String>("Already_locked",HttpStatus.ALREADY_REPORTED);
		 }
		 catch(Exception e) {
			 e.printStackTrace();
			 return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
			 
		 }
	 }
	
	
	      
	  
}
