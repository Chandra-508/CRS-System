/**
 * 
 */
package com.tcs.exception;

/**
 * @author Administrator
 *
 */
public class ProfessorAlreadyExists extends Exception {
private static final long serialVersionUID = 1L;
	
	
	private int professorId;
	   public ProfessorAlreadyExists(int professorId)
	   {
	      this.professorId = professorId;
	   } 
	   public int getProfessorId()
	   {
	      return professorId;
	   }

}
