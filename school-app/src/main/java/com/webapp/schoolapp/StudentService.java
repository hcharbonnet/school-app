package com.webapp.schoolapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
	@Autowired
	private StudentRepository studentRepository;
	
	public Long createNewStudent(Student student) {
		
		student = studentRepository.save(student);
		return student.getId();
	}

}
