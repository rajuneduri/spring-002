package com.example.demo.Error;

public class StudentNotFoundException extends RuntimeException {

	
	public StudentNotFoundException(String msg) {
		super(msg);
	}
}
