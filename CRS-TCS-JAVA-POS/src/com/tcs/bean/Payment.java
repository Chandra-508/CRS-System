/**
 * 
 */
package com.tcs.bean;

/**
 * @author Administrator
 *
 */


/*
 * @class: Payment
 * @param: studentId,studentName,coursesRegistered,amount
 * setters and getters for the payment attributes.
 * 
 */

public class Payment {
	
	private int studentId;
	private String studentName;
	private int coursesRegistered;
	private int amount;
	
	
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public int getCoursesRegistered() {
		return coursesRegistered;
	}
	public void setCoursesRegistered(int coursesRegistered) {
		this.coursesRegistered = coursesRegistered;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	

}
