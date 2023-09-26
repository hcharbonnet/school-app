package com.webapp.schoolapp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StudentService {
	@Autowired
	private StudentRepository studentRepository;
	
	public Long createNewStudent(Student student) {
		student = studentRepository.save(student);
		return student.getId();
	}
	
	public List<Student> getAllStudents() {
		return studentRepository.findAll();
	}
	
	public Student getStudentById(Long id) {
		Optional<Student> student = studentRepository.findById(id);
		if(student.isEmpty()) {
			throw new StudentNotFoundException("Student with id: " + id + " not found.");
		}
		return student.get();
	}
	
	public void deleteStudentById(Long id) {
		studentRepository.deleteById(id);
	}
	
	@Transactional
	public Student updateStudent(Student student) {
		Optional<Student> originalStudent = studentRepository.findById(student.getId());
		if(originalStudent.isEmpty()) {
			throw new StudentNotFoundException("Student with id: " + student.getId() + " does not exist.");
		}
		Student editedStudent = originalStudent.get();
		
		editedStudent.setFirstName(student.getFirstName());
		editedStudent.setLastName(student.getLastName());
		editedStudent.setEmailId(student.getEmailId());
		editedStudent.setAbsences(student.getAbsences());
		return editedStudent;
		
	}

}
