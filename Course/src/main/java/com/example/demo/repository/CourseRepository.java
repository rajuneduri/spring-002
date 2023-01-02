package com.example.demo.repository;

import java.util.List;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.Course;

public interface CourseRepository extends JpaRepository<Course, Integer>{
    @Transactional
	public Course findByCourseName(String courseName);
    @Transactional
	public Course findByCourseCost(Integer courseCost);

}
