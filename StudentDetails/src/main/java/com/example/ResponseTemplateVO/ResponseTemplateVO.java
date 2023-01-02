package com.example.ResponseTemplateVO;

import com.example.demo.entity.Student;

public class ResponseTemplateVO {
	public Student student;
	public Course course;
	public ResponseTemplateVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ResponseTemplateVO(Student student, Course course) {
		super();
		this.student = student;
		this.course = course;
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}

}
