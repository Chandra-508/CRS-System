package com.tcs.bean;

/**
 * @author Administrator
 *
 */



/*
 * @class: ADMIN
 * @param: adminID,adminName,adminPswd
 * setters and getters for the ADMIN attributes.
 * 
 * 
 */

public class Admin {
	
	private int adminID;
	private String adminName;
	private String adminpswd;

	
	public int getAdminID() {
		return adminID;
	}
	public void setAdminID(int adminID) {
		this.adminID = adminID;
	}
	public String getAdminName() {
		return adminName;
	}
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
	public String getAdminpswd() {
		return adminpswd;
	}
	public void setAdminpswd(String adminpswd) {
		this.adminpswd = adminpswd;
	}
	

}
