package com.crud.mysql.crudapp.dto;

public class StudentRequest {
	
	private Long studentId;
	private String enrolmentid;
	private String studentName;	
	
	public Long getStudentId() {
		return studentId;
	}
	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}
	public String getEnrolmentid() {
		return enrolmentid;
	}
	public void setEnrolmentid(String enrolmentid) {
		this.enrolmentid = enrolmentid;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	
}
