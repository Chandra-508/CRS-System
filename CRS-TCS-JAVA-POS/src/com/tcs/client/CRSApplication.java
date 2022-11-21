/**
 * 
 */
package com.tcs.client;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Scanner;

import com.tcs.bean.Admin;

import com.tcs.service.*;

import com.tcs.bean.Course;
import com.tcs.bean.Professor;
import com.tcs.bean.Student;

import java.util.*;
import com.tcs.service.UserServiceImp;
import com.tcs.service.UserServiceInterface;

/**
 * @author Administrator
 *
 */
public class CRSApplication {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc=new Scanner(System.in);
		
		UserServiceInterface usi=new UserServiceImp();
		AdminServiceInterface asi=new AdminServiceImp();
		ProfessorServiceInterface psi=new ProfessorServiceImp();
		StudentServiceInterface ssi=new StudentServiceImp();

		
		int ch1;
		
		do {
			LocalDate localDate=LocalDate.now();
			LocalTime localTime=LocalTime.now();
			LocalDateTime localDateTime=LocalDateTime.now();
			
			/*
			 * Main menu for login,student registration,update password
			 */
			
			System.out.println("\nWelcome to the CRS Application"+" "+localDate+" "+localTime);
			System.out.println("-----Main Menu-----");
			System.out.println("\n1.Login");
			System.out.println("2.Student Registration");
			System.out.println("3.Update Password");
			System.out.println("4.Exit");
			System.out.println("Enter your choice");
			ch1=sc.nextInt();sc.nextLine();
			
			switch(ch1)
			{
			case 1: System.out.println("Enter role to login");
			        String role=sc.nextLine();
			        if(role.equals("Admin"))
			        {
			        	boolean res1=usi.adminLogin();
			        	int ch5;
					       if(res1==true)
					       {
						   do
							{
							   System.out.println("-----Admin Menu-----");
						    System.out.println("1.Add Professor");
				    	    System.out.println("2.Add Course");
				    	    System.out.println("3.Remove Course");
				    	    System.out.println("4.Approve Student Registration");
				    	    System.out.println("5.Generate Report Card");
			                System.out.println("6.List Professors");
			                System.out.println("7.List Courses");
							System.out.println("8.Exit");
							System.out.println("Enter your choice");
							ch5=sc.nextInt();sc.nextLine();
							switch(ch5)
							{
							case 1:asi.addProfessor();
								   //System.out.println("Professor Added");
							       break;
							case 2:asi.addCourse();
								   //System.out.println("Course Added");
							       break;
							case 3:asi.removeCourse();
							       break;
							case 4: asi.approveStudentRegistration();
								    break;
							case 5:asi.generateReportCard();
							        break;
							case 6:asi.listProfessor();
							       break;
							case 7:asi.listCourses();
						           break;
							case 8:System.out.println("Exit"); 
					               break;   
							default:System.out.println("Wrong option selected! Choose options from 1 to 8");
					                break;
							     
							}
							}while(ch5!=8);
					       }
					       else
					       {
					    	   System.out.println("Login Failed! Enter Correct Credentials");
					       }
			
			        }
			        else if(role.equals("Professor"))
			        {
			        	boolean res2=usi.professorLogin();
			        	int ch4;
					      if(res2==true)
					       {
						    do
							{
						    	System.out.println("-----Professor Menu-----");					
							    System.out.println("1.Add Grades");
					    	    System.out.println("2.View Enrolled Students");
								System.out.println("3.Exit");
								System.out.println("Enter your choice");
								 ch4=sc.nextInt();sc.nextLine();
								switch(ch4)
								{
								case 1:psi.addGrades();
								       break;
								case 2:psi.viewEnrolledStudent();
									   break;	
								case 3:System.out.println("Exit"); 
					                   break; 
								default:System.out.println("Wrong option selected! Choose options from 1 to 3");
						         break;
								     
								}
							}
							while(ch4!=3);
					       }
					       
					       else
					       {
					    	   System.out.println("Login Failed! Enter Correct Credentials");
					       }
		
			        	
			        }
			        else if(role.equals("Student"))
			        {
			        	int ch3;
			        	boolean res3=usi.studentLogin();
			        	if(res3==true)
					       {
						   do
							{
							   
						    System.out.println("-----Student Menu-----");
						    System.out.println("1.Register for Course");
				    	    System.out.println("2.Add Course");
				    	    System.out.println("3.Drop Course");
				    	    System.out.println("4.View Grades");
				    	    System.out.println("5.Fee pay");
				    	    System.out.println("6.View Courses");
							System.out.println("7.Exit");
							System.out.println("Enter your choice");
							 ch3=sc.nextInt();sc.nextLine();
							switch(ch3)
							{
							case 1:ssi.courseRegister();
							       break;
							case 2:ssi.addCourse();
							       break;
							case 3:ssi.dropCourse();
							       break;
							case 4:ssi.viewReportCard();
								    break;
							case 5:ssi.payment();
							        break;
							case 6:ssi.viewCourses(); 
					               break;  
							case 7:System.out.println("Exit"); 
				                   break;  
							default:System.out.println("Wrong option selected! Choose options from 1 to 7");
					                 break;
							     
							}
							}while(ch3!=7);
						   }
					       else
					       {
					    	   System.out.println("Login Failed! Enter Correct Credentials");
					       }
							
			        }	
				    break;
			case 2:usi.studentRegistration();
			       break;
			case 3:usi.updatePassword();
				   System.out.println("Password Updated");
			       break;
			case 4:System.out.println("Exit"); 
			    break;
			    
		    default:System.out.println("Wrong option selected! Choose options from 1 to 4");
			      break;
				}
				
			}while(ch1!=4);
		
		
			}
		
					
				}
						
		
		



