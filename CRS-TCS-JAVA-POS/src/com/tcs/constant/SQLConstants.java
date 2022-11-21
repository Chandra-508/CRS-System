/**
 * 
 */
package com.tcs.constant;

/**
 * @author Administrator
 *
 */
  public class SQLConstants {

	public static final String APPROVED_LOGIN_ONE ="select * from registration where status=0";
	public static final String APPROVED_LOGIN_TWO ="insert into student values(?,?,?,?)";
   public static final String APPROVED_LOGIN_THREE ="insert into login values(?,?,?,?)";

	public static final String ADD_COURSE_ONE="select courseId from catalogue";
    public static final String ADD_COURSE_TWO ="insert into catalogue values(?,?,?,?,?)";
	
	public static final String ADD_PROFESSOR_ONE="select professorId from professor";
    public static final String ADD_PROFESSOR_TWO ="insert into professor values(?,?,?,?)";
    public static final String ADD_PROFESSOR_THREE="insert into login values(?,?,?,?)";
    
    public static final String LIST_PROFESSORS_ONE="select count(*) from professor";
    public static final String LIST_PROFESSORS_TWO="select * from professor";
    
    public static final String LIST_COURSES_ONE="select count(*) from catalogue";
    public static final String LIST_COURSES_TWO="select * from catalogue";
    
    public static final String REMOVE_COURSE_ONE="select courseId from catalogue";
    public static final String REMOVE_COURSE_TWO="select courseId,courseName from catalogue";
    
    public static final String ADD_GRADE_ONE="select studentId from grade";
    public static final String ADD_GRADE_TWO=" select * from grade";
    public static final String ADD_GRADE_THREE="insert into gradecard values(?,?,?)";
    public static final String ADD_GRADE_FOUR="insert into gradecard values(?,?,?)";
    public static final String ADD_GRADE_FIVE="insert into gradecard values(?,?,?)";
    public static final String ADD_GRADE_SIX="insert into gradecard values(?,?,?)";
    public static final String ADD_GRADE_SEVEN="insert into gradecard values(?,?,?)";
    
    public static final String VIEW_ENROLLED_ONE="select * from courseregistration";
    
   public static final String PROFESSOR_ADD_GRADE="select * from grade";
   public static final String PROFESSOR_ADD_GRADE1="select * from courseregistration";
   public static final String PROFESSOR_ADD_GRADE2="insert into grade(studentId,studentName,courseId,grade) values(?,?,?,?)";
   public static final String PROFESSOR_ADD_GRADE3="insert into grade values(?,?,?,?)";
   public static final String PROFESSOR_ADD_GRADE4="insert into grade values(?,?,?,?)";
   public static final String PROFESSOR_ADD_GRADE5="insert into grade values(?,?,?,?)";
   
   public static final String COURSE_REGISTER_ONE="select *  from courseregistration";
   public static final String COURSE_REGISTER_TWO="insert into courseregistration values(?,?,?,?,?,?)";
   
   public static final String STUDENT_ADD_COURSE1="select *  from courseregistration";
   
   public static final String STUDENT_DROP_COURSE1="select *  from courseregistration";
   public static final String STUDENT_VIEW_COURSES1="select * from courseregistration";
   public static final String STUDENT_VIEW_GRADES=" select * from grade";
   public static final String VIEW_PAYMENT1=" select studentId from payment";
   public static final String VIEW_PAYMENT2="insert into payment values(?,?,?,?,?,?)";
   
   public static final String STUDENT_REGISTRATION_1="insert into registration values(?,?,?,?,?)";
   public static final String ADMIN_LOGIN1="select username,password,roleId from login";
   public static final String STUDENT_LOGIN1="select username,password,roleId from login";
   public static final String PROFESSOR_LOGIN1="select username,password,roleId from login";
   public static final String UPDATE_PASSWORD1="select  loginId,roleId,password from login";
   
   

   
   
  }
