/**
 * 
 */
package com.tcs.service;

import java.util.ArrayList;
import java.util.List;


import com.tcs.bean.Student;
import com.tcs.dao.UserDao;
import com.tcs.dao.UserDaoImp1;
import com.tcs.bean.Admin;
import com.tcs.bean.Registration;
import com.tcs.bean.Professor;
import java.util.*;

/**
 * @author Administrator
 *
 */
public class UserServiceImp implements UserServiceInterface{
	Scanner sc=new Scanner(System.in);
 
	UserDao udi=new UserDaoImp1();
	
	
	
	/*
	  * @method: adminLogin
	  * 
	  * 
	  * @param: Admin ID
	  * @param: Admin Password
	  * 
	  * The Admin can login if the given credentials are correct.
	  * The method return true if the credentials are correct else return false.
	  * 
	  */
	
	@Override
	public boolean adminLogin() {
		
		
		System.out.println("Enter UserName");
		String inp1=sc.nextLine();
		
		System.out.println("Enter Password");
		String inp2=sc.nextLine();
      boolean al=udi.adminLogin(inp1,inp2);
		
		
		return al;
	}
	
	
	/*
	  * @method: studentLogin
	  * 
	  * 
	  * @param: Student UserName
	  * @param: Student Password
	  * 
	  * The student can login if the given credentials are correct.
	  * The method return true if the credentials are correct else return false.
	  * 
	  */
	
	
	@Override
	public boolean studentLogin() {
		// TODO Auto-generated method stub
		System.out.println("Enter UserName");
		String inp1=sc.nextLine();
		
		System.out.println("Enter Password");
		String inp2=sc.nextLine();
		
		
		 boolean sl=udi.studentLogin(inp1,inp2);
			
			
			return sl;
		
		}
	
	 
	
	
	/*
	  * @method: studentRegistration
	  * 
	  * @param: Student ID
	  * @param: Student Name
	  * @param: Student Password
	  * @param: Department
	  * 
	  * The student enters all the required details. The registration request is sent to admin. 
	  * If admin approves the student, then the student can login. 
	  * 
	  */
	
	@Override
	public void studentRegistration() {
		// TODO Auto-generated method stub
		Registration astu=new Registration();
		Student stu=new Student();
		
		System.out.println("Enter Student ID");
		int sid=sc.nextInt(); sc.nextLine();
		
		
		System.out.println("Enter Student Name");
		String sname=sc.nextLine();
		
		
		

		System.out.println("Enter Password");
		String spassword=sc.nextLine();
	
	

		System.out.println("Enter Department");
		String sdept=sc.nextLine();
		
		
		
		udi.studentRegistration(sid,sname,sdept,spassword);
	}
	
	
	/*
	  * @method: professorLogin
	  * 
	  * 
	  * @param: Professor UserName
	  * @param: Professor Password
	  * 
	  * The Professor can login if the given credentials are correct.
	  * The method return true if the credentials are correct else return false.
	  * 
	  */
	
	@Override
	public boolean professorLogin() {
		// TODO Auto-generated method stub
		System.out.println("Enter UserName");
		String inp1=sc.nextLine();
		
		System.out.println("Enter Password");
		String inp2=sc.nextLine();
		
		 boolean s2=udi.professorLogin(inp1,inp2);
			
			
			return s2;
	}
	
	
	/*
	  * @method: updatePassword
	  * 
	  * Student, Professor and Admin can change their password by giving their ID's,old password and new password.
	  * 
	  * @param: Student/Professor/Admin ID
	  * @param: old password
	  * @param: new password
	  * 
	  * The password is updated with the new password.
	  * 
	  */
	
	
	
	@Override
	public void updatePassword() 
	{
		
		       
		       System.out.println("Enter login Id");
		       int id=sc.nextInt();sc.nextLine();
		       System.out.println("Enter Old Password");
		       String oldpswd=sc.nextLine();
		       System.out.println("Enter new Password");
		       String newpswd=sc.nextLine();
		       
		       udi.updatePassword(id,oldpswd,newpswd);
			    
		
	 }
}
		
		
	
	
    
	
	
	


