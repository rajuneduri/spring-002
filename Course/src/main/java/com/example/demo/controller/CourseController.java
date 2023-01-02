package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Course;

import com.example.demo.repository.CourseRepository;
@RestController
@RequestMapping("/course")
public class CourseController {
	@Autowired
	CourseRepository repo;

	@PostMapping("/registercourse")
	public Course registerCourse(@RequestBody Course cou)
	{
		return repo.save(cou);
	}
	
	
	@GetMapping("/allcourses")
	public List<Course> allCourses()
	{
		return (List<Course>) repo.findAll();
	}
	@GetMapping("/courseid/{id}")
	public Course getId(@PathVariable("id") Integer courseId)
	{
		return repo.findById(courseId).orElse(new Course());
	}
	@DeleteMapping("/deletecourseid/{id}")
	public String deleteId(@PathVariable("id") Integer courseId) {
		repo.deleteById(courseId);
		return "Deleted Id Successfully";
	}
	@RequestMapping("/coursename/{courseName}")
	public Course getCourseName(@PathVariable("courseName") String courseName)
	{
		return repo.findByCourseName(courseName);
	}
	@RequestMapping("/coursecost/{courseCost}")
	public Course getCourseCost(@PathVariable("courseCost") Integer courseCost)
	{
		return repo.findByCourseCost(courseCost);
	}
	
}