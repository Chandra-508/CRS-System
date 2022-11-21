/**
 * 
 */
package com.tcs.dao;

/**
 * @author Administrator
 *
 */
import com.tcs.exception.StudentNotFound;
public interface ProfessorDao {
	public void viewEnrolledStudent(int cid) throws StudentNotFound;
	public void addGrades(int sid) throws StudentNotFound;	
}
