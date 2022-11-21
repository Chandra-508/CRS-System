package com.tcs.utils;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Administrator
 *
 */
public class DBUtils 
	{
				   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
				   static final String DB_URL = "jdbc:mysql://localhost/test";

				   //  Database credentials
				   static final String USER = "root";
				   static final String PASS = "root";
				   
				   public static Connection connect()
				   {
					   Connection conn=null;
					   try 
					   {
						   Class.forName("com.mysql.jdbc.Driver");
					   }
					   catch(ClassNotFoundException e)
					   {
						   e.printStackTrace();
					   }
					   try
					   {
						  conn = DriverManager.getConnection(DB_URL,USER,PASS);

					   }
					   catch(SQLException e)
					   {
						   e.printStackTrace();
					   }
					   return conn;
				   }
	}
