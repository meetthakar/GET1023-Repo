package model;

import java.time.LocalDate;

public class Registration {
	private int courseId;
	private LocalDate registrationDate;
	private int registrationNo;
	private int rollNo;
	
	public Registration() {
		// TODO Auto-generated constructor stub
	}

	public Registration(int courseId, LocalDate registrationDate, int rollNo) {
		super();
		this.courseId = courseId;
		this.registrationDate = registrationDate;
		this.rollNo = rollNo;
	}

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public LocalDate getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(LocalDate registrationDate) {
		this.registrationDate = registrationDate;
	}

	public int getRollNo() {
		return rollNo;
	}

	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}

	public int getRegistrationNo() {
		return registrationNo;
	}
	
	
}
