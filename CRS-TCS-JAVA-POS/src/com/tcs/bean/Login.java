/**
 * 
 */
package com.tcs.bean;

/**
 * @author Administrator
 *
 */

/*
 * @class: Login for student,professor,admin
 * @param: loginId,loginPassword
 * setters and getters for the login attributes.
 * 
 */
public class Login {
	
	private int loginId;
	private String loginPassword;
	
	
	public int getLoginId() {
		return loginId;
	}
	public void setLoginId(int loginId) {
		this.loginId = loginId;
	}
	public String getLoginPassword() {
		return loginPassword;
	}
	public void setLoginPassword(String loginPassword) {
		this.loginPassword = loginPassword;
	}
	
}
