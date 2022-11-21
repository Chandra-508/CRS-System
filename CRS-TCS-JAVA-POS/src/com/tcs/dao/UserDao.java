/**
 * 
 */
package com.tcs.dao;

/**
 * @author Administrator
 *
 */
public interface UserDao {

	public void studentRegistration(int sid,String sname,String sdept,String spassword);

	public boolean adminLogin(String inp1,String inp2);
	public boolean studentLogin(String inp1,String inp2);

	public boolean professorLogin(String inp1,String inp2);
	public void updatePassword(int id,String oldpswd,String newpswd);

}
