package com.webapp.schoolapp;

public class StudentNotFoundException extends RuntimeException{
	public StudentNotFoundException(String message) {
		super(message);
	}
}
