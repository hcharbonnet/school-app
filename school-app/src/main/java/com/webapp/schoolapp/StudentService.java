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
	public Student updateStudent(Student updatedStudent) {
		// first check that the student exists
		Optional<Student> originalStudent = studentRepository.findById(updatedStudent.getId());
		if(originalStudent.isEmpty()) {
			throw new StudentNotFoundException("Student with id: " + updatedStudent.getId() + " does not exist.");
		}
		Student studentInDB = originalStudent.get();
		// now update all the changes
		studentInDB.setFirstName(updatedStudent.getFirstName());
		studentInDB.setLastName(updatedStudent.getLastName());
		studentInDB.setEmailId(updatedStudent.getEmailId());
		studentInDB.setAbsences(updatedStudent.getAbsences());
		studentInDB.setTardy(updatedStudent.getTardy());
		studentInDB.setStanding(updatedStudent.getStanding());
		
		return studentInDB;
		
	}

}
