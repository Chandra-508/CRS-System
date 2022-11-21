/**
 * 
 */
package com.tcs.service;

import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;
import com.tcs.bean.Course;
import com.tcs.dao.StudentDao;
import com.tcs.dao.StudentDaoImp1;
import com.tcs.exception.StudentNotFound;


/**
 * @author Administrator
 *
 */
public class StudentServiceImp implements StudentServiceInterface{
	static List<Course> clist=new ArrayList<Course>();

	Scanner sc=new Scanner(System.in);
	StudentDao sdi=new StudentDaoImp1();
	
	
	 /*
	  * @method: courseRegister
	  * Student can register for courses
	  * 
	  * @param: Student Id,course Id's.
	  */
	
	
	@Override
	public void courseRegister() {
		// TODO Auto-generated method stub
		try {
		/*System.out.println("List of all courses");
		AdminServiceImp.cclist.forEach(System.out::println);

		Course stucourse=new Course();*/
			
			
		System.out.println("Enter student id");
		int sid=sc.nextInt();
		System.out.println("Enter course id1");
		int cid1=sc.nextInt();sc.nextLine();
		System.out.println("Enter course id2");
		int cid2=sc.nextInt();sc.nextLine();
		System.out.println("Enter course id3");
		int cid3=sc.nextInt();sc.nextLine();
		System.out.println("Enter course id4");
		int cid4=sc.nextInt();sc.nextLine();
		
		sdi.courseRegister(sid,cid1,cid2,cid3,cid4);
		
		
		/*boolean found=false;
		for(int i=0;i<clist.size();i++)
		{
			if(clist.get(i).getStudentId()==sid)
			{
				found=true;
				System.out.println("You already registered courses");
			}
		}
		if(found==false)
		{      
				stucourse.setStudentId(sid);sc.nextLine();
				System.out.println("Enter course id1");
				stucourse.setCourseId1(sc.nextInt());sc.nextLine();
				System.out.println("Enter course id2");
				stucourse.setCourseId2(sc.nextInt());sc.nextLine();
				System.out.println("Enter course id3");
				stucourse.setCourseId3(sc.nextInt());sc.nextLine();
				System.out.println("Enter course id4");
				stucourse.setCourseId4(sc.nextInt());sc.nextLine();
				clist.add(stucourse);
				System.out.println("Courses Registration Successfull!");
				
		  
		}*/
		 
		
		
		}
		catch(StudentNotFound e)
		{
			System.out.println("Student with Id"+e.getStudentId()+"has already registered");
		}
			}
		
		
	/*
	  * @method: addCourse
	  * In a particular time period student is able to add courses.
	  * 
	  * @param: Student Id,course Id's.
	  * @param: statedate From this date student can add course
	  * @param: enddate After this date student can't add course
	  * 
	  */
	
			
		

	@Override
	public void addCourse() {
		// TODO Auto-generated method stub
		try {
		LocalDate localDate=LocalDate.now();
		LocalTime localTime=LocalTime.now();
		LocalDateTime localDateTime=LocalDateTime.now();
		LocalDate startdate=LocalDate.of(2022, 11, 11);
		LocalDate enddate=LocalDate.of(2022, 11, 18);
	   if(localDate.compareTo(startdate) >= 0 && localDate.compareTo(enddate)<=0)
		{
			System.out.println("Enter your student id");
			int id=sc.nextInt();sc.nextLine();
			/***if(clist.size()<=0)
			{
				System.out.println("You didn't registered any courses yet");
			}
			for(int i=0;i<clist.size();i++)
			{
				if(clist.get(i).getStudentId()==id)
				{
				if(clist.get(i).getCourseId1()==0)
				{
					System.out.println("Enter course Id to add");
					clist.get(i).setCourseId1(sc.nextInt());
				}
				else if(clist.get(i).getCourseId2()==0)
				{
					System.out.println("Enter course Id to add");
					clist.get(i).setCourseId2(sc.nextInt());
					}
				else if(clist.get(i).getCourseId3()==0)
				{
					System.out.println("Enter course Id to add");
					clist.get(i).setCourseId3(sc.nextInt());
					}
				else if(clist.get(i).getCourseId4()==0)
				{
					System.out.println("Enter course Id to add");
					clist.get(i).setCourseId4(sc.nextInt());					
				}
				else
				{
					System.out.println("You have already registered 4 courses.To add a new course,remove one course from already registered courses.");				
					}
			    }
			
			
		 }***/
			sdi.addCourse(id);
		}
		else
		{
			System.out.println("You cannot add course now. From"+startdate+" "+"you can add courses");
		}
		}
		catch(StudentNotFound e)
		{
			System.out.println(e.getMsg());
		}
		
	}

	
	/*
	  * @method: dropCourse
	  * In a particular time period student is able to drop courses.
	  * 
	  * @param: Student Id,course Id's.
	  * @param: dstatedate  From this date student can drop course
	  * @param: denddate    After this date student can't drop course
	  * 
	  */
	
	 
	@Override
	public void dropCourse() {
		// TODO Auto-generated method stub
		try {
		LocalDate localDate=LocalDate.now();
		LocalTime localTime=LocalTime.now();
		LocalDateTime localDateTime=LocalDateTime.now();
		LocalDate dstartdate=LocalDate.of(2022, 11, 11);
		LocalDate denddate=LocalDate.of(2022, 11, 18);
		boolean found1=false;
		if(localDate.compareTo(dstartdate) >= 0 && localDate.compareTo(denddate)<=0)
		{
			System.out.println("Enter your student id");
			int id=sc.nextInt();sc.nextLine();
			
			/***for(int i=0;i<clist.size();i++)
			{
				if(clist.get(i).getStudentId()==id)
				{
					found1=true;
				}
			}
			
			if(found1==true)
			{
				System.out.println("Enter course id you want to drop");
			    int dcourse=sc.nextInt();sc.nextLine();	
			    for(int i=0;i<clist.size();i++)
			    {
			    	if(clist.get(i).getStudentId()==id)
			    	{
			    		if(clist.get(i).getCourseId1()==dcourse)
			    		{
			    			clist.get(i).setCourseId1(0);
							System.out.println("Course dropped");

			    		}
			    		else if(clist.get(i).getCourseId2()==dcourse)
			    		{
			    			clist.get(i).setCourseId2(0);
							System.out.println("Course dropped");

			    		}
			    		else if(clist.get(i).getCourseId3()==dcourse)
			    		{
			    			clist.get(i).setCourseId3(0);
							System.out.println("Course dropped");

			    		}
			    		else if(clist.get(i).getCourseId4()==dcourse)
			    		{
			    			clist.get(i).setCourseId4(0);
							System.out.println("Course dropped");

			    		}
			    		else
			    		{
			    			System.out.println("Course Id not found");
			    		}
			    		
			    		
			    	}
			    	
			    	
			    }***/
			sdi.dropCourse(id);
		
	    }
		else
		{
			System.out.println("You cannot remove course now. From" +dstartdate+" "+"you can remove courses");
		}
		}
		catch(StudentNotFound e)
		{
			System.out.println(e.getMsg());
		}
	}

	
	/*
	  * @method: viewReportCard
	  * prints courses with respective grades added by professor
	  * 
	  * @param: Student Id Based on the student Id,grades are displayed with course id's.
	  * 
	  */
	
	@Override
	public void viewReportCard() {
		// TODO Auto-generated method stub
		try
		{
		//int count=0;
		System.out.println("Enter Student Id");
		int sid=sc.nextInt();
		
		/***System.out.println("Course ID         Grade");

		for(int i=0;i< ProfessorServiceImp.grade.size();i++)
		{
			if(ProfessorServiceImp.grade.get(i).getStuId()==sid)
			{     count++;
			      
				System.out.println(ProfessorServiceImp.grade.get(i).getCourseID()+"     "+ProfessorServiceImp.grade.get(i).getGrade());
			}
		}
		
		if(count<=0)
		{
			System.out.println("Student ID not found");
		}
		else
		{
		System.out.println("---------------------------------------");
		
		}***/
		sdi.viewReportCard(sid);
		}
		catch(StudentNotFound e)
		{
			System.out.println(e.getMsg());
		}
		
		
	}

	
	/*
	  * @method: payment
	  * Student has to pay for the registered courses.
	  * 
	  * @param: Student Id.
	  * @param: cfee cfee is the amount for a course
	  * @param: count counts the number of courses registered
	  * @param: amount  Total amount the student has to pay
	  * 
	  * Student has to choose the payment mode- Offline  or Online
	  * 
	  */
	
	@Override
	public void payment() {
		// TODO Auto-generated method stub
		try {
		double amount=1;
		double cfee=10;
		int count=0;
		System.out.println("Enter student ID");
		int sid=sc.nextInt();sc.nextLine();
		
		/*for(int i=0;i<clist.size();i++)
		{
			if(clist.get(i).getStudentId()==sid)
			{
			if(clist.get(i).getCourseId1()!=0)
			{
				count++;
			}
			 if(clist.get(i).getCourseId2()!=0)
			{
				count++;
			}
				if(clist.get(i).getCourseId3()!=0)
				{
					count++;
				}
					if(clist.get(i).getCourseId4()!=0)
					{
						count++;
					}
				}
			}
		
		amount=cfee*count;
		
		System.out.println("You have to pay Rs." +amount);
	    System.out.println("Mode of Payment");
	    System.out.println("1.Online Payment");
	    System.out.println("2.Offline payment");
	    System.out.println("Enter your choice");
	    int ch=sc.nextInt();
	    if(ch==1)
	    {
	    	System.out.println("Enter card number");
	    	long cardNumber=sc.nextLong();sc.nextLine();
	    	System.out.println("Enter CVV");
	    	int cvv=sc.nextInt();sc.nextLine();
	    	System.out.println("Payment Successfull!");
	    }
	    else
	    {
	    	System.out.println("You have to pay Rs."+amount+"."+" Visit CRS Office to clear the due");
	    }
			*/
		
		sdi.payment(sid);
			
				
		}
		catch(StudentNotFound e)
		{
			System.out.println(e.getMsg());
		}
	}
		
		
		
		
		
	/*
	  * @method: viewCourses
	  * Student can see all the courses from the course catalogue
	  * 
	  */
	

	@Override
	public void viewCourses() {
		// TODO Auto-generated method stub
		/*System.out.println("All courses list from course Catalogue");
		AdminServiceImp.cclist.forEach(System.out::println);
		System.out.println("student and courses registration details");
		clist.forEach(System.out::println);*/
		try {
		System.out.println("Enter Your Student Id");
		int g=sc.nextInt();
		sdi.viewCourses(g);
		}
		catch(StudentNotFound e)
		{
			System.out.println("No registered courses to display for this Student Id:"+e.getStudentId());
		}
		
		
	}

	

}
