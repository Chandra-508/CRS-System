/**
 * 
 */
package com.tcs.bean;

/**
 * @author Administrator
 *
 */



/*
 * @class: ReportCard
 * @param: studentId,studentName,courseId,courseName,grade
 * setters and getters for the ReportCard attributes.
 * 
 */

public class GradeCard {
	
	private int studentId;
	private String studentName;
    private String result;
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
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	@Override
	public String toString() {
		return "GradeCard [studentId=" + studentId + ", studentName=" + studentName + ", result=" + result + "]";
	}
	
	
}
