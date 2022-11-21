/**
 * 
 */
package com.tcs.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.tcs.constant.SQLConstants;
import com.tcs.utils.DBUtils;
/**
 * @author Administrator
 *
 */
public class UserDaoImp1 implements UserDao {
	PreparedStatement stmt = null;
    DBUtils cc=new DBUtils();
    Connection conn=cc.connect();
    
	@Override
	public void studentRegistration(int sid, String sname,  String sdept,String spassword) {
		// TODO Auto-generated method stub
		//String sql="insert into registration values(?,?,?,?,?)";
   	 
	   	 try {
	   	 stmt = conn.prepareStatement(SQLConstants.STUDENT_REGISTRATION_1);
	   	 stmt.setInt(1,sid);
	   	 stmt.setString(2, sname);
	   	 stmt.setString(3,sdept);
	   	 stmt.setString(4,spassword);
	   	 stmt.setInt(5, 0);
	   	 stmt.executeUpdate();
	     System.out.println("Registration request sent to admin for approval! Login after sometime.");

	   	 
	        }
		     catch(SQLException se2){
		    	 System.out.println("UserID already exists");
		      }// nothing we can do
	   	 
	   	 
	   	 
		}
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
	public boolean adminLogin(String inp1, String inp2) {
		// TODO Auto-generated method stub
		
		ResultSet rs;
		try {
			//String s1="select username,password,roleId from login";
			stmt=conn.prepareStatement(SQLConstants.ADMIN_LOGIN1);
			rs = stmt.executeQuery();
			while(rs.next()){
		        //Retrieve by column name
		        String adminName = rs.getString("username");
		        String adminpswd = rs.getString("password");
		        int roleId=rs.getInt("roleId");
		        if(adminName.equals(inp1)&& adminpswd.equals(inp2) && roleId==1 ) {
		        	return true;
		        }
		        
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
		
		
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
	public boolean studentLogin(String inp1, String inp2) {
		// TODO Auto-generated method stub
		
		ResultSet rs;
		try {
			//String s1="select username,password,roleId from login";
			stmt=conn.prepareStatement(SQLConstants.STUDENT_LOGIN1);
			rs = stmt.executeQuery();
			while(rs.next()){
		        //Retrieve by column name
		        String sname = rs.getString("username");
		        String spswd = rs.getString("password");
		        int roleId=rs.getInt("roleId");
		        if(sname.equals(inp1)&& spswd.equals(inp2) && roleId==3) {
		        	return true;
		        }
		        
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
		
		
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
	public boolean professorLogin(String inp1, String inp2) {
		// TODO Auto-generated method stub
		
		ResultSet rs;
		try {
			//String s1="select username,password,roleId from login";
			stmt=conn.prepareStatement(SQLConstants.PROFESSOR_LOGIN1);
			rs = stmt.executeQuery();
			while(rs.next()){
		        //Retrieve by column name
		        String sname = rs.getString("username");
		        String spswd = rs.getString("password");
		        int roleId=rs.getInt("roleId");

		        if(sname.equals(inp1)&& spswd.equals(inp2) && roleId==2) {
		        	return true;
		        }
		        
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
		
		
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
	public void updatePassword(int id,String oldpswd, String newpswd) {
		
		
		try
		{
			//String sql1="select  loginId,roleId,password from login";

			stmt=conn.prepareStatement(SQLConstants.UPDATE_PASSWORD1);

		    ResultSet rs = stmt.executeQuery(SQLConstants.UPDATE_PASSWORD1);
		    while(rs.next()){
		     
		        	 int roleid  = rs.getInt("roleId");
		        	 int loginId=rs.getInt("loginId");
		        	 String old1=rs.getString("password");
		        	 
			     	 if(loginId==id && old1.equals(oldpswd) && roleid==1)
					{   
					 String sql7="update login as l ,admin as a set l.password='"+newpswd+"', a.adminPassword='"+newpswd+"' where loginId='"+loginId+"' AND roleid='"+roleid+"'";
					 stmt=conn.prepareStatement(sql7);
					 stmt.executeUpdate(sql7);
					}
					else if(loginId==id && old1.equals(oldpswd) && roleid==2)
					{
						String sql8="update login as l ,professor as p set l.password='"+newpswd+"', p.professorPassword='"+newpswd+"' where professorId='"+loginId+"' AND loginId='"+loginId+"' AND roleId='"+roleid+"'";
						 stmt=conn.prepareStatement(sql8);
						 stmt.executeUpdate(sql8);
					}
					else if(loginId==id && old1.equals(oldpswd) && roleid==3)
					{
						String sql9="update login as l ,student as s set l.password='"+newpswd+"', s.studentPassword='"+newpswd+"' where studentId='"+loginId+"' AND loginId='"+loginId+"' AND roleId='"+roleid+"'";
						 stmt=conn.prepareStatement(sql9);
						 stmt.executeUpdate(sql9);
					}
		
		
		}
		
	
	}catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	}
}
	
