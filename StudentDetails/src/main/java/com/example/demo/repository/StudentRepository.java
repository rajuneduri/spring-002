package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer>{
@Transactional
public Student findByStudentName(String studentName);
@Transactional
public Optional<Student> findByCourseName(String courseName);


}
