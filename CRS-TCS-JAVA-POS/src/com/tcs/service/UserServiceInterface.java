/**
 * 
 */
package com.tcs.service;

/**
 * @author Administrator
 *
 */
public interface UserServiceInterface {
	public boolean adminLogin();
	public boolean studentLogin();
	public boolean professorLogin();
	public void studentRegistration();
	public void updatePassword();

}
