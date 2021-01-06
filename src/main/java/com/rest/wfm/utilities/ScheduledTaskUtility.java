package com.rest.wfm.utilities;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.rest.wfm.entity.Employee;
import com.rest.wfm.entity.Softlock;
import com.rest.wfm.repositories.SoftlockRepository;
import com.rest.wfm.services.WorkforceService;

@Component
public class ScheduledTaskUtility {
	@Autowired
	  SoftlockRepository srepo;
	@Autowired
	  WorkforceService wservice;
	//Runs Every Twelve hour once 
	@Scheduled(fixedRate = 12*60*60*1000)  //millseconds
	public void reportCurrentTime() {
		System.out.println("Firing Firing Firing Firing....@#E@#");
	   List<Softlock> l=srepo.getExpired();
	   List<Softlock> l2=srepo.getUnAccepted();
	   for(Softlock x:l)
	   {
		  x.setStatus("declined");
		  x.setWfmremark("Request Expired");
		  try {
			wservice.updateSoftlinkRequest(x);
		} catch (AlreadyRequestedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	   }
	   
	   for(Softlock x:l2) {
		   x.setStatus("declined");
			  x.setWfmremark("Approval not accepted within 7 days");
			  try {
				wservice.updateSoftlinkRequest(x);
			} catch (AlreadyRequestedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	   }
	}
	
	
}
