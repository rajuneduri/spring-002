package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import java.util.*;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.ResponseTemplateVO.Course;
import com.example.ResponseTemplateVO.ResponseTemplateVO;
import com.example.demo.Error.InvalidTypeErrorException;
import com.example.demo.Error.StudentNotFoundException;
import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepository;
import com.google.common.base.Optional;

@RestController
@RequestMapping("/student")
public class StudentController {

	@Autowired
	StudentRepository repo;
	
	@Autowired
	RestTemplate restTemplate;

	@PostMapping("/registerstudent")
	public Student registerStudents(@RequestBody Student stu) {
		return repo.save(stu);

	}
	@GetMapping("/allstudents")
	public List<Student> allStudents() {
		return (List<Student>) repo.findAll();
	}

	@GetMapping("/studentid/{id}")
	public java.util.Optional<Student> getId(@PathVariable("id") Integer StudentId) {
		
		java.util.Optional<Student> student=repo.findById(StudentId);
		if(student.isEmpty()) {
			throw new StudentNotFoundException("Student with id"+StudentId+" Not found");
		}
		else {
			return student;
		}
	}

	@DeleteMapping("/deleteid/{id}")
	public String deleteid(@PathVariable("id") Integer StudentId) {
		repo.deleteById(StudentId);
		return "Deleted id Successfully";
	}

	@GetMapping("/studentname/{studentName}")
	public ResponseTemplateVO getByNamess(@PathVariable("studentName") String studentName) {
		ResponseTemplateVO vo = new ResponseTemplateVO();
		Student student = repo.findByStudentName(studentName);
		
		Course course = restTemplate.getForObject("http://localhost:9998/course/coursename/" + student.getCourseName(),
				Course.class);
		vo.setStudent(student);
		vo.setCourse(course);
		return vo;
	}

	@GetMapping("/coursename/{courseName}")
	public java.util.Optional<Student> getByCourse(@Valid @PathVariable("courseName") String courseName) {
		java.util.Optional<Student> student=repo.findByCourseName(courseName);
		if(student.isEmpty()) {
			throw new InvalidTypeErrorException("Invalid Type Of Exception    "+courseName);
		}
		else {
			return student;
		}
	}
	@GetMapping("/coursedetails")
	public List<String> allcourses(){
		List<Student> stu= repo.findAll();
		List<String> courselist=new ArrayList<>();
		for(Student s:stu) {
			courselist.add(s.getCourseName());
		}
		return courselist;
	}

}
