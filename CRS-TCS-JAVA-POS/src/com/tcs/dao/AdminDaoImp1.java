package com.tcs.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;

import com.tcs.constant.SQLConstants;
import com.tcs.exception.CourseAlreadyExists;
import com.tcs.exception.ProfessorAlreadyExists;
import com.tcs.exception.CourseNotFound;
import com.tcs.exception.StudentGradesNotFound;
import com.tcs.exception.ProfessorNotFound;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import com.tcs.utils.DBUtils;
/**
 * @author Administrator
 *
 */
public class AdminDaoImp1 implements AdminDao {
	PreparedStatement stmt = null;
	PreparedStatement stmt1 = null;

    DBUtils cc=new DBUtils();
    Connection conn=cc.connect();
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
	public void approveRegistration()
	{
		
		try {
			//string sql="select * from registration where status=0";
		    stmt=conn.prepareStatement(SQLConstants.APPROVED_LOGIN_ONE);

		    ResultSet rs = stmt.executeQuery(SQLConstants.APPROVED_LOGIN_ONE);


		      //STEP 5: Extract data from result set
		      while(rs.next()){
		         if(rs.getInt("status")==0)
		         {
		        	 int sid  = rs.getInt("studentId");
			         String sname = rs.getString("studentName");
			         String sdept = rs.getString("studentDepartment");
			         String spswd=rs.getString("studentPassword");
			         
		        	 //System.out.println("This student needs to be approved");
		        	 System.out.println(rs.getInt("studentId") +" " +rs.getString("studentName"));
		        	 System.out.println("Enter 1 to approve the student");
		        	 int approve=sc.nextInt(); 
		        	 if(approve==1)
		        		 {
		        		 String sql2="update registration set status=1 where studentId= '"+rs.getInt("studentId")+"'";
		        		 stmt=conn.prepareStatement(sql2);
		        		 stmt.executeUpdate(sql2);
		        		 System.out.println("Student Approved");
		        		 
		        		 
		        		 //For student table
		        		 //String sql1="insert into student values(?,?,?,?)";
		        			try {
		        			   	 stmt = conn.prepareStatement(SQLConstants.APPROVED_LOGIN_TWO);
		        			   	 stmt.setInt(1,sid);
		        			   	 stmt.setString(2, sname);
		        			   	 stmt.setString(3,sdept);
		        			   	 stmt.setString(4,spswd);
		        			   	 stmt.executeUpdate();
		        			   	 
		        			        }
		        				     catch(SQLException se2){
		        				      }// nothing we can do
		        			
		        			
		        			
		        			
		        			
		        			//For login table
		        			// String sql3="insert into login values(?,?,?,?)";
			        			try {
			        			   	 stmt = conn.prepareStatement(SQLConstants.APPROVED_LOGIN_THREE);
			        			   	 stmt.setString(1,sname);
			        			   	 stmt.setString(2, spswd);
			        			   	 stmt.setInt(3, 3);
			        			   	 stmt.setInt(4, sid);
			        			   	 stmt.executeUpdate();
			        			   	 
			        			        }
			        				     catch(SQLException se2){
			        				    	 se2.printStackTrace();
			        				      }// nothing we can do
		        				
		        		 }
		         }
		         
				
		}
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
	
		
		
		
	}
	/*
	  * @method: addCourse
	  * ADMIN can add course to course CATALOGUE
	  * 
	  * @param: course id,course name,professor name,department,prerequisites
	  */
	
	
	@Override
	public void addCourse(int cid,String cname,String pname,String dept,String pre) throws CourseAlreadyExists
	{
		
  
	   	 try {
	   		 //String sql2="select courseId from catalogue";
		   	 stmt = conn.prepareStatement(SQLConstants.ADD_COURSE_ONE);
			    ResultSet rs = stmt.executeQuery(SQLConstants.ADD_COURSE_ONE);
			    while(rs.next())
			    {
			    	if(cid==rs.getInt("courseId"))
			    	{
			    		throw new CourseAlreadyExists(cid);
			    	}
			    }

	   		 
	 		//String sql="insert into catalogue values(?,?,?,?,?)";
		   	 stmt = conn.prepareStatement(SQLConstants.ADD_COURSE_TWO);
		   	 stmt.setInt(1,cid);
		   	 stmt.setString(2, cname);
		   	 stmt.setString(3,pname);
		   	 stmt.setString(4,dept);
		   	 stmt.setString(5, pre);
		   	 stmt.executeUpdate();
		   	 System.out.println("Course added successfully");
		   	 //f=true;
		   	 
	   	 
	        }
		   	
		     catch(SQLException se2){
		      }// nothing we can do
			   
		
	}
	/*
	  * @method: addProfessor
	  * ADMIN can add professor details
	  * 
	  * @param: Professor ID,professor Name,Department,Professor Password(default password- which can be updated by professor).
	  */
	
	
	@Override
	public void addProfessor(int pid,String pname,String ppswd,String dept) throws ProfessorAlreadyExists
	{
		
	   	 
	   	 try {
	   		//String sql2="select professorId from professor";
		   	 stmt = conn.prepareStatement(SQLConstants.ADD_PROFESSOR_ONE);
			    ResultSet rs = stmt.executeQuery(SQLConstants.ADD_PROFESSOR_ONE);
			    while(rs.next())
			    {
			    	if(pid==rs.getInt("professorId"))
			    	{
			    		throw new ProfessorAlreadyExists(pid);
			    	}
			    }
	 		//String sql="insert into professor values(?,?,?,?)";

	   	 stmt = conn.prepareStatement(SQLConstants.ADD_PROFESSOR_TWO);
	   	 stmt.setInt(1,pid);
	   	 stmt.setString(2, pname);
	   	 stmt.setString(3,ppswd);
	   	 stmt.setString(4,dept);
	   	 stmt.executeUpdate();
	   	 System.out.println("Professor added succesfully");
	   	 
	        }
		     catch(SQLException se2){
		      }// nothing we can do
		
	   //	String sql4="insert into login values(?,?,?,?)";
		try {
		   	 stmt = conn.prepareStatement(SQLConstants.ADD_PROFESSOR_THREE);
		   	 stmt.setString(1,pname);
		   	 stmt.setString(2, ppswd);
		   	 stmt.setInt(3, 2);
		   	 stmt.setInt(4, pid);
		   	 stmt.executeUpdate();
		   	 
		        }
			     catch(SQLException se2){
			      }// nothing we can do
		
	}

	
	 /*
	  * @method: listProfessor
	  * This method prints all the Professor details.
	  * 
	  */
	@Override
	public void listProfessor() throws ProfessorNotFound
	{
		try
		{
			//String sql2="select count(*) from professor";
			 stmt = conn.prepareStatement(SQLConstants.LIST_PROFESSORS_ONE);
			    ResultSet rs1 = stmt.executeQuery(SQLConstants.LIST_PROFESSORS_ONE);
			    while(rs1.next())
			    {
			    
			    	if(rs1.getInt("count(*)")<=0)
			    	{
			    		//f=true;
			    		throw new ProfessorNotFound("No Professor Found");
			    	}
			    }
			
			
			//String sql="select * from professor";
			ResultSet rs = stmt.executeQuery(SQLConstants.LIST_PROFESSORS_TWO);
	         System.out.println("Professor Details are:");

		      //STEP 5: Extract data from result set
		      while(rs.next()){
		         //Retrieve by column name
		         int pid  = rs.getInt("professorId");
		         String pname = rs.getString("professorName");
		         String pdept = rs.getString("department");

		         //Display values
		         System.out.print("Professor ID: " + pid);
		         System.out.print(", Professor Name: " + pname);
		         System.out.println(", Department: " + pdept);
		}

		
		
	  }
		catch(SQLException se2){
      }// nothing we can do
		
	}
	
	 /*
	  * @method: listCourses
	  * This method prints all the student enrolled courses details.
	  * 
	  */
	@Override
	public void listCourses() throws CourseNotFound
	{
		try
		{
			
			//String sql2="select count(*) from catalogue";
			 stmt = conn.prepareStatement(SQLConstants.LIST_COURSES_ONE);
			    ResultSet rs1 = stmt.executeQuery(SQLConstants.LIST_COURSES_ONE);
			    while(rs1.next())
			    {
			    
			    	if(rs1.getInt("count(*)")<=0)
			    	{
			    		//f=true;
			    		throw new CourseNotFound("No Course Found");
			    	}
			    }
			
			String sql="select * from catalogue";
			ResultSet rs = stmt.executeQuery(SQLConstants.LIST_COURSES_TWO);

		      //STEP 5: Extract data from result set
		      while(rs.next()){
		         //Retrieve by column name
		         int cid  = rs.getInt("courseID");
		         String cname = rs.getString("courseName");
		         String pname = rs.getString("professor");
		         String pdept = rs.getString("department");
		         String pre = rs.getString("prerequisites");

		         //Display values
		        
		         System.out.print("Course ID: " + cid);
		         System.out.print(", Course Name: " + cname);
		         System.out.print(", Professor Name: " + pname);
		         System.out.print(", Professor Department: " + pdept);
		         System.out.println(", Prerequisites for this course Id is: " + pre);
		}

		
		
	  }
		
		catch(SQLException se2){
      }// nothing we can do
		
	}
	

	
	
	@Override
	public void removeCourse(int inp) throws CourseNotFound
	{
		try {
			boolean f=false;

			//String sql3="select courseId from catalogue";
		   	 stmt = conn.prepareStatement(SQLConstants.REMOVE_COURSE_ONE);
			    ResultSet rs1 = stmt.executeQuery(SQLConstants.REMOVE_COURSE_ONE);
			    while(rs1.next())
			    {
			    
			    	if(inp==rs1.getInt("courseId"))
			    	{
			    		f=true;
			    	}
			    	
			    	
			    }
			    if(f==false)
			    {
			    	
			    		throw new CourseNotFound(inp);
			    	
			    }
			    
			    
			//String sql="select courseId,courseName from catalogue";
		    stmt=conn.prepareStatement(SQLConstants.REMOVE_COURSE_TWO);

		    ResultSet rs = stmt.executeQuery(SQLConstants.REMOVE_COURSE_TWO);


		      //STEP 5: Extract data from result set
		      while(rs.next()){
		         if(rs.getInt("courseId")==inp)
		         {
		        	 
		        	// System.out.println(rs.getInt("studentId") +" " +rs.getString("studentName"));
		        	
		        		 String sql2="delete from  catalogue where courseId= '"+rs.getInt("courseId")+"'";
		        		 stmt=conn.prepareStatement(sql2);
		        		 stmt.executeUpdate(sql2);
		        		 System.out.println(rs.getInt("courseID") +" " +rs.getString("courseName")+" is  Removed Successfully");
		        		 
		         }
		         
				
		}
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	public void gradeCard(int sid,String sname) throws StudentGradesNotFound
	{
		boolean f1=false;
		System.out.println("Student Id:"+sid+"   "+"StudentName:"+"  "+sname);
		try
		{
			//String sql3="select studentId from grade";
		   	 stmt = conn.prepareStatement(SQLConstants.ADD_GRADE_ONE);
			    ResultSet rs1 = stmt.executeQuery(SQLConstants.ADD_GRADE_ONE);
			    while(rs1.next())
			    {
			    
			    	if(sid==rs1.getInt("studentId"))
			    	{
			    		f1=true;
			    	}
			    	
			    	
			    }
			    if(f1==false)
			    {
		    		throw new StudentGradesNotFound(sid,sname);

			    }
			
			
			//int a=0,b=0,c=0,d=0,f=0;
			//String sql="select * from grade";
			stmt=conn.prepareStatement(SQLConstants.ADD_GRADE_TWO);
			ResultSet rs = stmt.executeQuery(SQLConstants.ADD_GRADE_TWO);
	         int a=0,b=0,c=0,d=0,f=0;

			System.out.println("Course Id:                         Grade:");
		      while(rs.next()){
		         //Retrieve by column name
		         int sid1  = rs.getInt("studentID");
		         String sname1 = rs.getString("studentName");
		         int cid = rs.getInt("courseId");
		         String g = rs.getString("grade");
		         
		         if(sid1==sid)
		         {
		        	 f1=true;
		        	 System.out.println(cid+"                        "+g);
		         }
		        
		         
		         if(g.equals("A"))
		         {

		        	 a=a+1;
		        	 
		        	 
		         }
		         else if(g.equals("B"))
		         {
		        	 b=b+1;
		        	  
		        	 
		         }
		         else if(g.equals("c"))
		         {
		        	 c=c+1;
		        	
		        	 
		         }
		         else if(g.equals("D"))
		         {
		        	 d=d+1;
		        	
		        	 
		         }
		         else
		         {
		        	 f=f+1;
		         }
		        
		      }
		      
		      if(a>3)
	        	 {
	        		 //String sql4="insert into gradecard values(?,?,?)";
	        		 stmt1=conn.prepareStatement(SQLConstants.ADD_GRADE_THREE);
	        		 stmt1.setInt(1, sid);
	        		 stmt1.setString(2, sname);
	        		 stmt1.setString(3,"Distinction");
	        		 stmt1.executeUpdate();
	        		 
	        		 
	        	 }
		      
		      else if(b>3)
	        	 {
	        		 
	        		 //String sql4="insert into gradecard values(?,?,?)";
	        		 stmt1=conn.prepareStatement(SQLConstants.ADD_GRADE_FOUR);
	        		 stmt1.setInt(1, sid);
	        		 stmt1.setString(2, sname);
	        		 stmt1.setString(3,"Passed With 70%");
	        		 stmt1.executeUpdate();
	        		 
	        		 
	        	 }
		      
		      else  if(c>3)
	        	 {
	        		 
	        		 //String sql4="insert into gradecard values(?,?,?)";
	        		 stmt1=conn.prepareStatement(SQLConstants.ADD_GRADE_FIVE);
	        		 stmt1.setInt(1, sid);
	        		 stmt1.setString(2, sname);
	        		 stmt1.setString(3,"Passed with 60%");
	        		 stmt1.executeUpdate();
	        		 
	        		 
	        	 }
		      else  if(d>3)
	        	 {
	        		 
	        		 //String sql4="insert into gradecard values(?,?,?)";
	        		 stmt1=conn.prepareStatement(SQLConstants.ADD_GRADE_SIX);
	        		 stmt1.setInt(1, sid);
	        		 stmt1.setString(2, sname);
	        		 stmt1.setString(3,"Passed with 55%");
	        		 stmt1.executeUpdate();
	        		 
	        		 
	        	 }
		      else if(f==1)
		    	  {
		    	  //String sql4="insert into gradecard values(?,?,?)";
		    	  
	        	 stmt1=conn.prepareStatement(SQLConstants.ADD_GRADE_SEVEN);
	        	 stmt1.setInt(1, sid);
	        	 stmt1.setString(2, sname);
	        	 stmt1.setString(3,"Failed");
	        	 stmt1.executeUpdate();
		    	  }
		      
		      
		      
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Student ID not found or card already generated ");
		}
		         
		
	}
}
	
	

	
