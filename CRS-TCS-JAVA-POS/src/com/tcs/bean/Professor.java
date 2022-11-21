/**
 * 
 */
package com.tcs.bean;

/**
 * @author Administrator
 *
 */




/*
 * @class: Professor
 * @param: professorId,professorName,password,department
 * setters and getters for the professor attributes.
 * 
 */

public class Professor {
	
	private int professorId;
	private String professorName;
	private String professorPassword;
	private int noOfCoursesOffered;
	private String department;
	
	public int getProfessorId() {
		return professorId;
	}
	public void setProfessorId(int professorId) {
		this.professorId = professorId;
	}
	
	
	public int getNoOfCoursesOffered() {
		return noOfCoursesOffered;
	}
	public void setNoOfCoursesOffered(int noOfCoursesOffered) {
		this.noOfCoursesOffered = noOfCoursesOffered;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	
	public String getProfessorName() {
		return professorName;
	}
	public void setProfessorName(String professorName) {
		this.professorName = professorName;
	}
	public String getProfessorPassword() {
		return professorPassword;
	}
	public void setProfessorPassword(String professorPassword) {
		this.professorPassword = professorPassword;
	}
	
	
	@Override
	public String toString() {
		return "professorId=" + professorId + " " + "professorName=" + professorName + " "+ "noOfCoursesOffered="
				+ noOfCoursesOffered +" " + "department=" + department +"\n ";
	}
	

}
