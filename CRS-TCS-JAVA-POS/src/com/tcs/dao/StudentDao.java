/**
 * 
 */
package com.tcs.dao;
import com.tcs.exception.StudentNotFound;

/**
 * @author Administrator
 *
 */
public interface StudentDao {
	public void courseRegister(int sid,int cid1,int cid2,int cid3,int cid4) throws StudentNotFound;
	public void addCourse(int sid) throws StudentNotFound;
	public void dropCourse(int sid) throws StudentNotFound;
	public void viewCourses(int g) throws StudentNotFound;
	public void viewReportCard(int sid) throws StudentNotFound;
	public void payment(int sid) throws StudentNotFound;
	
}
