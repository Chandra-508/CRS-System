/**
 * 
 */
package com.tcs.bean;

/**
 * @author Administrator
 *
 */


/*
 * @class: Course
 * @param: studentID,courseId1,courseId2,courseId3,courseId4
 * setters and getters for the course attributes.
 * 
 *student enrolled courses details
 * 
 * 
 */
public class Course {
	private int studentId;
	private int courseId1;
	private int courseId2;
	private int courseId3;
	private int courseId4;
	
	
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public int getCourseId1() {
		return courseId1;
	}
	public void setCourseId1(int courseId1) {
		this.courseId1 = courseId1;
	}
	public int getCourseId2() {
		return courseId2;
	}
	public void setCourseId2(int courseId2) {
		this.courseId2 = courseId2;
	}
	public int getCourseId3() {
		return courseId3;
	}
	public void setCourseId3(int courseId3) {
		this.courseId3 = courseId3;
	}
	public int getCourseId4() {
		return courseId4;
	}
	public void setCourseId4(int courseId4) {
		this.courseId4 = courseId4;
	}
	
	@Override
	public String toString() {
		return "studentId=" + studentId + ", courseId1=" + courseId1 + ", courseId2=" + courseId2
				+ ", courseId3=" + courseId3 + ", courseId4=" + courseId4;
	
	
}

}