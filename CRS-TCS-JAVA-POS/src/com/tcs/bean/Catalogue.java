/**
 * 
 */
package com.tcs.bean;

/**
 * @author Administrator
 *
 */



/*
 * @class: Catalogue
 * @param: courseID,courseName,professor,department,prerequisites
 * setters and getters for the Catalogue attributes.
 * 
 */

public class Catalogue {
	
	private int courseId;
	private String courseName;
	private String professor;
	private String department;
	private String prerequisites;
	
	
	public int getCourseId() {
		return courseId;
	}
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getPrerequisites() {
		return prerequisites;
	}
	public void setPrerequisites(String prerequisites) {
		this.prerequisites = prerequisites;
	}
	
	public String getProfessor() {
		return professor;
	}
	public void setProfessor(String professor) {
		this.professor = professor;
	}
	@Override
	public String toString() {
		return "courseId= "+ courseId +" "+ "courseName= " +courseName +" professor= " + professor
				+" "+ "department= "+department +" "+"prerequisites= "+ prerequisites;
	}

}
