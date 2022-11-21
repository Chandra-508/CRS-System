/**
 * 
 */
package com.tcs.exception;

/**
 * @author Administrator
 *
 */
public class StudentGradesNotFound extends Exception {
	
private static final long serialVersionUID = 1L;
	
	
	private int studentId;
	private String studentName;
	   public StudentGradesNotFound(int studentId,String studentName)
	   {
	      this.studentId = studentId;
	      this.studentName=studentName;

	   } 
	   public int getStudentId()
	   {
	      return studentId;
	   }

	    
	   public String getStudentName()
	   {
	      return studentName;
	   }


}
