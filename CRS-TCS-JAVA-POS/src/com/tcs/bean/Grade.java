/**
 * 
 */
package com.tcs.bean;

/**
 * @author Administrator
 *
 */



/*
 * @class: Grade
 * @param: courseID,studentId,studentName,grade
 * setters and getters for the grade attributes.
 * 
 */


public class Grade {
	private int stuId;
	private String StuName;
	private int courseID;
	private String grade;
	
	public int getStuId() {
		return stuId;
	}
	public void setStuId(int stuId) {
		this.stuId = stuId;
	}
	public String getStuName() {
		return StuName;
	}
	public void setStuName(String stuName) {
		StuName = stuName;
	}
	public int getCourseID() {
		return courseID;
	}
	public void setCourseID(int courseID) {
		this.courseID = courseID;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	
	@Override
	public String toString() {
		return "stuId=" + stuId + ", StuName=" + StuName + ", courseID=" + courseID + ", grade=" + grade;
	}
	

}
