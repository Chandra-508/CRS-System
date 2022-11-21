/**
 * 
 */
package com.tcs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.tcs.constant.SQLConstants;
import com.tcs.exception.ProfessorAlreadyExists;
import com.tcs.exception.StudentNotFound;
import com.tcs.utils.DBUtils;

/**
 * @author Administrator
 *
 */
public class StudentDaoImp1 implements StudentDao {
	PreparedStatement stmt = null;
    DBUtils cc=new DBUtils();
    Connection conn=cc.connect();
    Scanner sc=new Scanner(System.in);
    
    
    
	@Override
	public void courseRegister(int sid, int cid1, int cid2, int cid3, int cid4) throws StudentNotFound {
		// TODO Auto-generated method stub
		boolean f=false;
		
		
		try {
			    //String sql="select *  from courseregistration";
				ResultSet rs;
			stmt=conn.prepareStatement(SQLConstants.COURSE_REGISTER_ONE);
			rs = stmt.executeQuery();
			while(rs.next()){
		        //Retrieve by column name
				int stuid=rs.getInt("studentId");
				String sname=rs.getString("studentName");
				int scid1 = rs.getInt("courseId1");
				int scid2= rs.getInt("courseId2");
				int scid3 = rs.getInt("courseId3");
				int scid4 = rs.getInt("courseId4");
				if(stuid==sid)
		        {
					f=true;
		        	break;
		        }
			
				else
				{
				//String sql1="insert into courseregistration values(?,?,?,?,?,?)";
    			
			   	 stmt = conn.prepareStatement(SQLConstants.COURSE_REGISTER_TWO);
			   	 stmt.setInt(1,sid);
			   	 stmt.setString(2, sname);
			   	 stmt.setInt(3, cid1);
			   	 stmt.setInt(4,cid2);
			   	 stmt.setInt(5,cid3);
			   	stmt.setInt(6,cid4);
			   	 stmt.executeUpdate();
			   	 System.out.println("Courses registerd succefully");
			   	 break;
			}
			}
			if(f==true)
			{
				throw new StudentNotFound(sid);
			}
			

	    
		
	}catch (SQLException e) {
	}

}
	
	public void addCourse(int sid) throws StudentNotFound {
	
		//String sql="select *  from courseregistration";
		ResultSet rs;
		boolean g=false;
		boolean f=false;
		try {
			stmt=conn.prepareStatement(SQLConstants.STUDENT_ADD_COURSE1);
			rs = stmt.executeQuery();
			while(rs.next()){
		        //Retrieve by column name
				int stuid=rs.getInt("studentId");
				String sname=rs.getString("studentName");
				int scid1 = rs.getInt("courseId1");
				int scid2= rs.getInt("courseId2");
				int scid3 = rs.getInt("courseId3");
				int scid4 = rs.getInt("courseId4");
				if(stuid==sid) {
					f=true;
					
				if(scid1==0)
				{
					System.out.println("Enter course Id to add");
					int s=sc.nextInt();
					String sql1="update courseregistration as c set c.courseId1='"+s+"' where studentId='"+sid+"'";
					stmt = conn.prepareStatement(sql1);
					stmt.executeUpdate();
					g=true;
					System.out.println("Your Course Got Added Successfully!");
				}
				else if(scid2==0)
				{
					System.out.println("Enter course Id to add");
					int s=sc.nextInt();
					String sql2="update courseregistration as c set c.courseId2='"+s+"' where studentId='"+sid+"'";
					stmt = conn.prepareStatement(sql2);
					stmt.executeUpdate();
					g=true;
					System.out.println("Your Course Got Added Successfully!");
				}
				else if(scid3==0)
				{
					System.out.println("Enter course Id to add");
					int s=sc.nextInt();
					String sql3="update courseregistration as c set c.courseId3='"+s+"' where studentId='"+sid+"'";
					stmt = conn.prepareStatement(sql3);
					stmt.executeUpdate();
					g=true;
					System.out.println("Your Course Got Added Successfully!");
				}
				else if(scid4==0)
				{
					System.out.println("Enter course Id to add");
					int s=sc.nextInt();
					String sql4="update courseregistration as c set c.courseId4='"+s+"' where studentId='"+sid+"'";
					stmt = conn.prepareStatement(sql4);
					stmt.executeUpdate();
					g=true;
					System.out.println("Your Course Got Added Successfully!");
					
				}
				else {
					System.out.println("You Had Already registered To The 4 Courses !,Drop Any Course ");
				}
			}
              }
			if(f==false)
			{
				throw new StudentNotFound("Student Not yet registered for any courses");
			}
			
			
		}
		catch (SQLException e) {
          		// TODO Auto-generated catch block
          		e.printStackTrace();
          		System.out.println("You are already registered");
		
	}
}
	public void dropCourse(int sid) throws StudentNotFound {
		boolean f=false;
		//String sql="select *  from courseregistration";
		ResultSet rs;
		try {
			stmt=conn.prepareStatement(SQLConstants.STUDENT_DROP_COURSE1);
			rs = stmt.executeQuery();
			System.out.println("Enter course Id to drop:");
			int s=sc.nextInt();
			while(rs.next()){
		        //Retrieve by column name
				int stuid=rs.getInt("studentId");
				String sname=rs.getString("studentName");
				int scid1 = rs.getInt("courseId1");
				int scid2= rs.getInt("courseId2");
				int scid3 = rs.getInt("courseId3");
				int scid4 = rs.getInt("courseId4");
				
				if(stuid==sid) {
					f=true;
					if(scid1==s)
					{
					String sql1="update courseregistration as c set c.courseId1='"+0+"' where studentId='"+sid+"'";
						stmt = conn.prepareStatement(sql1);
						stmt.executeUpdate();
						System.out.println("Your Course Got Removed Successfully!");
					}
					else if(scid2==s)
					{
					String sql1="update courseregistration as c set c.courseId2='"+0+"' where studentId='"+sid+"'";
						stmt = conn.prepareStatement(sql1);
						stmt.executeUpdate();
						System.out.println("Your Course Got Removed Successfully!");
					}
					else if(scid3==s)
						{
						String sql1="update courseregistration as c set c.courseId3='"+0+"' where studentId='"+sid+"'";
							stmt = conn.prepareStatement(sql1);
							stmt.executeUpdate();
							System.out.println("Your Course Got Removed Successfully!");
						}
					else if(scid4==s)
					{
					String sql1="update courseregistration as c set c.courseId4='"+0+"' where studentId='"+sid+"'";
						stmt = conn.prepareStatement(sql1);
						stmt.executeUpdate();
						System.out.println("Your Course Got Removed Successfully!");
					}
					else {
						System.out.println("No Course Id Found !");
					}
					
				}
					
				}
			if(f==false)
			{
				throw new StudentNotFound("You did not registered for any courses to drop");
			}
	}catch (SQLException e) {
  		// TODO Auto-generated catch block
  		e.printStackTrace();
  		System.out.println("You Had Already Removed That CourseId");
	}

}
	@Override
	public void viewCourses(int g)throws StudentNotFound
	{
		try
		{
			boolean f=false;
			//String sql="select * from courseregistration";
			
			stmt=conn.prepareStatement(SQLConstants.STUDENT_VIEW_COURSES1);
			ResultSet rs = stmt.executeQuery(SQLConstants.STUDENT_VIEW_COURSES1);
		      //STEP 5: Extract data from result set
		      while(rs.next()){
		         //Retrieve by column name
		    	 int sid  = rs.getInt("studentId");
		    	 String sname=rs.getString("studentName");
		         int cid1 = rs.getInt("courseId1");
		         int cid2  = rs.getInt("courseId2");
		         int cid3  = rs.getInt("courseId3");
		         int cid4 = rs.getInt("courseId4");
		         

		         //Display values
		         if(sid==g) {
		        System.out.println("Student Id:"+sid);
		        System.out.println("Student Name:"+sname);
		        System.out.print("Course ID1: " + cid1);
		         System.out.print("Course ID2: " + cid2);
		         System.out.print("Course ID3: " + cid3);
		         System.out.print("Course ID4: " + cid4);
		         System.out.println();
		         f=true;
		      }
		   }
		      if(f==false)
		      {
		    	  throw new StudentNotFound(g);
		      }
		}
		catch(SQLException se2){
      }// nothing we can do
		
	}
public void viewReportCard(int sid)throws StudentNotFound {
	boolean f1=false;
	
	try
	{
		//String sql="select * from grade";
		stmt=conn.prepareStatement(SQLConstants.STUDENT_VIEW_GRADES);
		ResultSet rs = stmt.executeQuery(SQLConstants.STUDENT_VIEW_GRADES);
		System.out.println("Course Id:                Grade:");
	      while(rs.next()){
	         //Retrieve by column name
	         int sid1  = rs.getInt("studentID");
	         String sname1 = rs.getString("studentName");
	         int cid = rs.getInt("courseId");
	         String g = rs.getString("grade");
	         if(sid1==sid) {
	        	 f1=true;
	        	 System.out.println(cid+"                      "+g);
	         }
	      }
	      if(f1==false) {
	    	  throw new StudentNotFound("You dont have any grades");
	      }
	}catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
	  




	public void payment(int sid) throws StudentNotFound{
		
		int count=0;
		
		try {
			boolean f=false;
			boolean g=false;
			String sql3="select studentId from payment";
		   	 stmt = conn.prepareStatement(SQLConstants.VIEW_PAYMENT1);
			    ResultSet rs1 = stmt.executeQuery(SQLConstants.VIEW_PAYMENT1);
			    while(rs1.next())
			    {
			    	if(sid==rs1.getInt("studentId"))
			    	{
			    		throw new StudentNotFound("No Due");
			    	}
			    }
			
		String sql1="select * from courseregistration where studentId='"+sid+"'";
		stmt=conn.prepareStatement(sql1);
		ResultSet rs = stmt.executeQuery(sql1);
	      while(rs.next()){
	         //Retrieve by column name
	         int sid1  = rs.getInt("studentID");
	         String sname1 = rs.getString("studentName");
	         int cid1 = rs.getInt("courseId1");
	         int cid2 = rs.getInt("courseId2");
	         int cid3 = rs.getInt("courseId3");
	         int cid4 = rs.getInt("courseId4");

	         
		if(sid1==sid)
		{f=true;
			if(cid1!=0 && cid2!=0 && cid3!=0 && cid4!=0)
			{   
				System.out.println("you have to pay 2000");
				System.out.println("Enter payment Mode");
				System.out.println("1.Online Payment"+" "+"2.Offline");
				int ch=sc.nextInt();sc.nextLine();
				String mode=null;
				switch(ch)
				{
				case 1: mode = "Online Payment";
				        System.out.println("Enter card number");
				        int cardnum=sc.nextInt();sc.nextLine();
				        System.out.println("Enter cvv");
				        int cvv=sc.nextInt();sc.nextLine();
				        //String sql2="insert into payment values(?,?,?,?,?,?)";
				        stmt=conn.prepareStatement(SQLConstants.VIEW_PAYMENT2);
				        stmt.setInt(1, sid1);
				        stmt.setString(2,sname1);
				        stmt.setInt(3, 2000);
				        stmt.setString(4, mode);
				        stmt.setInt(5, cardnum);
				        stmt.setInt(6,0);
				        stmt.executeUpdate();
				        
				        System.out.println("Payment Successfull");
				        break;
				case 2: mode = "Cash";
				        System.out.println("Go to Course Registration Office and pay");
				        break;
				}
				
			}
			else
			{
				
				System.out.println("You did not registered four courses!");
			}
		}
		
		
		
		   
			}
	      if(f==false)
			{
				System.out.println("You did not registered for any courses to pay fee ");
			}
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		}
				
	}
	

