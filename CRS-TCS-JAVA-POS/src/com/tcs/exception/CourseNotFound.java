/**
 * 
 */
package com.tcs.exception;

/**
 * @author Administrator
 *
 */
public class CourseNotFound extends Exception {
private static final long serialVersionUID = 1L;
	
	
	private int courseId;
	private String msg;
	   public CourseNotFound(int courseId)
	   {
	      this.courseId = courseId;
	   } 
	   public int getCourseId()
	   {
	      return courseId;
	   }
	   public CourseNotFound(String msg)
	   {
		   this.msg=msg;
	   }
	  
	   public String getMsg()
	   {
		   return msg;
	   } 
	  
}
