/**
 * 
 */
package com.tcs.exception;

/**
 * @author Administrator
 *
 */
public class CourseAlreadyExists extends Exception{
private static final long serialVersionUID = 1L;
	
	
	private int courseId;
	   public CourseAlreadyExists(int courseId)
	   {
	      this.courseId = courseId;
	   } 
	   public int getCourseId()
	   {
	      return courseId;
	   }

}
