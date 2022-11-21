/**
 * 
 */
package com.tcs.service;

import com.tcs.bean.Course;
import com.tcs.bean.GradeCard;
import com.tcs.bean.Catalogue;
import com.tcs.bean.Professor;
import com.tcs.bean.Student;
import com.tcs.dao.AdminDao;
import com.tcs.dao.AdminDaoImp1;
import com.tcs.dao.UserDao;
import com.tcs.dao.UserDaoImp1;
import com.tcs.exception.CourseAlreadyExists;
import com.tcs.exception.CourseNotFound;
import com.tcs.exception.ProfessorAlreadyExists;
import com.tcs.exception.ProfessorNotFound;
import com.tcs.exception.StudentGradesNotFound;

import java.util.*;
import com.tcs.service.UserServiceImp;
import com.tcs.service.UserServiceInterface;

/**
 * @author Administrator
 *
 */
public class AdminServiceImp implements AdminServiceInterface{
	UserServiceImp usimp=new UserServiceImp();
	static List<Catalogue> cclist=new ArrayList<Catalogue>();
	AdminDao adi = new AdminDaoImp1();
	
  static List<GradeCard> gcard=new ArrayList<GradeCard>();
	 Scanner sc=new Scanner(System.in);
	 
	 
	 /*
	  * @method: approveStudentRegistration
	  * ADMIN has to approve the student registration by using student ID
	  * 
	  * @param: sid  Student ID
	  * @param: status ADMIN set the status value to 1 to approve the student.
	  *
	  */
	 
	@Override
	public void approveStudentRegistration() {
		// TODO Auto-generated method stub
		
        adi.approveRegistration();
		
	}

	 /*
	  * @method: addCourse
	  * ADMIN can add course to course CATALOGUE
	  * 
	  * @param: course id,course name,professor name,department,prerequisites
	  */
	
	@Override
	public void addCourse() {
		// TODO Auto-generated method stub
		try {
        
		
		System.out.println("Enter Course ID");
	    int cid=sc.nextInt();
	    sc.nextLine();
	    System.out.println("Enter Course Name");
	    String cname=sc.nextLine();
	    System.out.println("Enter Professor Name");
	    String pname=sc.nextLine();
	    System.out.println("Enter Department");
	    String dept=sc.nextLine();
	    System.out.println("Enter Prerequisites");
	    String pre=sc.nextLine();
	  	
	    adi.addCourse(cid,cname,pname,dept,pre);
		}
		catch(CourseAlreadyExists e)
		{
			System.out.println("Course Id "+e.getCourseId()+" already exists");
		}
		
	}
	
	
	 /*
	  * @method: removeCourse
	  * Admin can remove course from course catalogue by using the course ID.
	  * 
	  * @param: Course ID The course Id is used to search whether the course exists or not.If exists then remove the course
	  *          else print course id not found.
	  */

	@Override
	public void removeCourse() {
		// TODO Auto-generated method stub
		try {
		
		System.out.println("Enter Course ID");
		int inp=sc.nextInt();
		adi.removeCourse(inp);
		}
		catch(CourseNotFound e)
		{
			System.out.println("Course ID"+e.getCourseId()+" not found");
		}
		
	}

	
	
	
	 /*
	  * @method: generateReportCard
	  * ADMIN can generate report card of a particular student using student Id.
	  * 
	  * @param: Student ID The student Id is used to search whether the student exists or not.
	  *         If exists the report card is generated and printed else prints student not found.
	  */
	
	@Override
	public void generateReportCard() {
		// TODO Auto-generated method stub
		try
		{
		//int count=0;
		System.out.println("Enter Student Id");
		int sid=sc.nextInt();sc.nextLine();
		System.out.println("Enter Student Name");
		String sname=sc.nextLine();
	
		/***int gA=0,gB=0,gC=0,gD=0,gF=0;
		int courseId;
		String stuGrade;
		String result;
		System.out.println("Report Card");
		System.out.println("Course ID         Grade");

		for(int i=0;i< ProfessorServiceImp.grade.size();i++)
		{
			if(ProfessorServiceImp.grade.get(i).getStuId()==sid)
			{    count++;
			      courseId=ProfessorServiceImp.grade.get(i).getCourseID();
			      stuGrade=ProfessorServiceImp.grade.get(i).getGrade();
			      if(stuGrade.equalsIgnoreCase("A"))
					{
						gA=gA+1;
					}
			      else if(stuGrade.equalsIgnoreCase("B"))
			      {
			    	  gB=gB+1;
			      }
			      else if(stuGrade.equalsIgnoreCase("C"))
			      {
			    	 gC=gC+1;
			      }
			      else if(stuGrade.equalsIgnoreCase("D"))
			      {
			    	  gD=gD+1;
			      }
			      else
			      {
			    	  gF=gF+1;
			      }
			      
				System.out.println(courseId+"                   "+stuGrade);
			}
		}
		GradeCard gc=new GradeCard();
		System.out.println("---------------------------------------");
		if(gF>=1)
		{   result="Failed";
			gc.setStudentId(sid);
			gc.setStudentName(sname);
			gc.setResult(result);
			gcard.add(gc);
			System.out.println("Result    *****  Failed  *****");
		}
		else if(gA>3)
		{
			result="Distinction with 80%";
			gc.setStudentId(sid);
			gc.setStudentName(sname);
			gc.setResult(result);
			gcard.add(gc);
			System.out.println("Result    ***** Distinction with 80% *****");
		}
		else if(gB>3)
		{
			result="Pass with 70%";
			gc.setStudentId(sid);
			gc.setStudentName(sname);
			gc.setResult(result);
			gcard.add(gc);
			System.out.println("Result    ***** Pass with 70% *****");
		}
		else if(gC>3)
		{
			result="Pass with 60%";
			gc.setStudentId(sid);
			gc.setStudentName(sname);
			gc.setResult(result);
			gcard.add(gc);
			System.out.println("Result    ***** Pass with 60% *****");
		}
		else
		{
			result="Pass with 55%";
			gc.setStudentId(sid);
			gc.setStudentName(sname);
			gc.setResult(result);
			gcard.add(gc);
			System.out.println("Result    ***** Pass with 55% *****");

		}
		
		
		if(count<=0)
		{
			System.out.println("Student ID not found");
		}***/
		adi.gradeCard(sid,sname);
		}
		catch(StudentGradesNotFound e)
		{
			System.out.println("Grades for Student Id"+e.getStudentId()+"Student Name"+e.getStudentName()+" not found");
			//e.printStackTrace();
		}
	}

	
	

	 /*
	  * @method: addProfessor
	  * Admin can add professor details
	  * 
	  * @param: Professor ID,professor Name,Department,Professor Password(default password- which can be updated by professor).
	  */
	
	
	@Override
	public void addProfessor() {
		// TODO Auto-generated method stub
		try {
		//Professor pro=new Professor();
		
		System.out.println("Enter Professor Id");
	    int pid=sc.nextInt();
	    sc.nextLine();
	    System.out.println("Enter Professor Name");
	    String pname=sc.nextLine();
	    System.out.println("Enter Department");
	    String dept=sc.nextLine();
	    
	    System.out.println("Enter Professor Password");
	    String ppswd=sc.nextLine();
	    //UserServiceImp.plist.add(pro);
	    adi.addProfessor(pid,pname,ppswd,dept);
		}
		catch(ProfessorAlreadyExists e)
		{
			System.out.println("Professor Id "+e.getProfessorId()+" already exists");
		}
	}
 
	 

	 /*
	  * @method: listProfessor
	  * This method prints all the professors details.
	  * 
	  * @param: plist plist is the professor list.
	  */
	  
	@Override
	public void listProfessor()  {
		// TODO Auto-generated method stub
		try {
		System.out.println("----Professors List-----");
		
		adi.listProfessor();
		}catch(ProfessorNotFound e)
		{
			System.out.println(e.getMsg());
		}
		
		
		
	}
	
	
	 /*
	  * @method: listCourses
	  * This method prints all the student enrolled courses details.
	  * 
	  */
	
	public void listCourses() {
		// TODO Auto-generated method stub
		try {
		System.out.println("----Courses List-----");
		adi.listCourses();
		}
		catch(CourseNotFound e)
		{
			System.out.println(e.getMsg());
		}
		

		
	}

	
}
