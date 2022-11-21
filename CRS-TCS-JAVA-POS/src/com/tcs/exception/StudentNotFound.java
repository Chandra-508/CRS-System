/**
 * 
 */
package com.tcs.exception;

/**
 * @author Administrator
 *
 */
public class StudentNotFound extends Exception{
private static final long serialVersionUID = 1L;
	
	private int studentId;
	private String msg;
	
	public StudentNotFound(int studentId)
	   {
		   this.studentId=studentId;
	   }
	  
	   public int getStudentId()
	   {
		   return studentId;
	   } 
	   
	   public StudentNotFound(String msg)
	   {
		   this.msg=msg;
	   }
	  
	   public String getMsg()
	   {
		   return msg;
	   } 

}
