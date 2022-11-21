/**
 * 
 */
package com.tcs.bean;

/**
 * @author Administrator
 *
 */




/*
 * @class: ApproveStudentRegistration
 * @param: studentId,studentName,department,password.
 * setters and getters for the student registration attributes.
 * 
 * 
 */

public class Registration {
	private int studentId;
	private String studentName;
	private String studentDepartment;
	private String studentPassword;
	private int status=0;
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
	public String getStudentDepartment() {
		return studentDepartment;
	}
	public void setStudentDepartment(String studentDepartment) {
		this.studentDepartment = studentDepartment;
	}
	public String getStudentPassword() {
		return studentPassword;
	}
	public void setStudentPassword(String studentPassword) {
		this.studentPassword = studentPassword;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "studentId=" + studentId + ", studentName=" + studentName + ", studentDepartment="
				+ studentDepartment + ", status=" + status;
	}

}
