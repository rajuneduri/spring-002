package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Course {
	@Id
	private int courseId;
	private String courseName;
	private int courseCost;
	
	
	
	public Course() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Course(int courseId, String courseName, int courseCost) {
		super();
		this.courseId = courseId;
		this.courseName = courseName;
		this.courseCost = courseCost;
	}
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
	public int getCourseCost() {
		return courseCost;
	}
	public void setCourseCost(int courseCost) {
		this.courseCost = courseCost;
	}
	@Override
	public String toString() {
		return "Course [courseId=" + courseId + ", courseName=" + courseName + ", courseCost=" + courseCost + "]";
	}
	
	

}
