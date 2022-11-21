/**
 * 
 */
package com.tcs.service;
import java.util.*;

import com.tcs.bean.Grade;
import com.tcs.bean.Student;
import com.tcs.dao.AdminDao;
import com.tcs.dao.AdminDaoImp1;
import com.tcs.dao.ProfessorDao;
import com.tcs.dao.ProfessorDaoImp1;
import com.tcs.exception.StudentNotFound;
/**
 * @author Administrator
 *
 */
public class ProfessorServiceImp implements ProfessorServiceInterface {

	Scanner sc=new Scanner(System.in);
	static List<Grade> grade=new ArrayList<>();
	
	ProfessorDao pdi = new ProfessorDaoImp1();
	
	
	
	 /*
	  * @method: viewEnrolledStudent
	  * Professor can view the students who enrolled for particular course.
	  * 
	  * @param: Course ID Using the courseID professor can list the students who enrolled for that course. 
	  */
	
	@Override
	public void viewEnrolledStudent() {
		// TODO Auto-generated method stub
		try {
		System.out.println("Enter course ID");
		int cid=sc.nextInt();sc.nextLine();
		int count=0;
		System.out.println("Enrolled Students list");
		pdi.viewEnrolledStudent(cid);
		}
		catch(StudentNotFound e)
		{
			System.out.println(e.getMsg());
		}
		
	}

	
	
	 /*
	  * @method: addGrades
	  * Professor can add grades to a course of a particular student.
	  * 
	  * @param: student id,course id,grade
	  */
	
	@Override
	public void addGrades()
	{
		// TODO Auto-generated method stub
		try 
		{
		System.out.println("Enter Student Id");
		int sid=sc.nextInt();sc.nextLine();
		pdi.addGrades(sid);
		}
		catch(StudentNotFound e)
		{
			System.out.println("Already grades added to the Student with  Id:"+e.getStudentId());
		}
	}
	}
		
	

