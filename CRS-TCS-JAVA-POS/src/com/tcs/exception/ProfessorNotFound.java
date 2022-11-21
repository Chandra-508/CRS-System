/**
 * 
 */
package com.tcs.exception;

/**
 * @author Administrator
 *
 */
public class ProfessorNotFound extends Exception {
private static final long serialVersionUID = 1L;
	
	
	private String msg;
	   
	 public ProfessorNotFound(String msg)
	   {
		   this.msg=msg;
	   }
	  
	   public String getMsg()
	   {
		   return msg;
	   } 
}
