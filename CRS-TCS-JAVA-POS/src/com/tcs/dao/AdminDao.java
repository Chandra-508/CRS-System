/**
 * 
 */
package com.tcs.dao;

import com.tcs.exception.CourseAlreadyExists;
import com.tcs.exception.ProfessorAlreadyExists;
import com.tcs.exception.CourseNotFound;
import com.tcs.exception.StudentGradesNotFound;
import com.tcs.exception.ProfessorNotFound;



/**
 * @author Administrator
 *
 */
public interface AdminDao {
	
	public void approveRegistration();
	public void addCourse(int cid,String cname,String pname,String dept,String pre) throws CourseAlreadyExists;
	public void addProfessor(int pid,String pname,String ppswd,String dept) throws ProfessorAlreadyExists;
	public void listProfessor() throws ProfessorNotFound;
	public void listCourses() throws CourseNotFound;
	public void removeCourse(int inp) throws CourseNotFound;
	public void gradeCard(int sid,String sname) throws StudentGradesNotFound;
	
}
