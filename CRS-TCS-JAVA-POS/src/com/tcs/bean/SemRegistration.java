/**
 * 
 */
package com.tcs.bean;

/**
 * @author Administrator
 *
 */

/*
 * @class: SemRegistration
 * @param: studentId,studentName,semester,regulation
 * setters and getters for the  registration attributes.
 * 
 */

public class SemRegistration {
	
	private int studentId;
	private String studentName;
	private int semester;
	private String regulation;
	
	
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
	public int getSemester() {
		return semester;
	}
	public void setSemester(int semester) {
		this.semester = semester;
	}
	public String getRegulation() {
		return regulation;
	}
	public void setRegulation(String regulation) {
		this.regulation = regulation;
	}
	
	

}
