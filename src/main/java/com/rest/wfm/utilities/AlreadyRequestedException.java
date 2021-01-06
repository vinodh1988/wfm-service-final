package com.rest.wfm.utilities;

public class AlreadyRequestedException extends Exception
{
   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

public String toString() {
	   return "Already Requested Exception";
   }
   
   public String getMessage() {
	   return "Already Requested Exception";
   }
}

