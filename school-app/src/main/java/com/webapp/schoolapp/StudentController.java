package com.webapp.schoolapp;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.web.util.UriComponents;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/api/students")
public class StudentController {

	@Autowired
	private StudentService studentService;

	@PostMapping("/{id}")
	public ResponseEntity<Void> createdNewStudent(@Valid @RequestBody Student student, UriComponentsBuilder uriComponentsBuilder){
		Long id = studentService.createNewStudent(student);
		UriComponents uriComponents = uriComponentsBuilder.path("/api/students/{id}").buildAndExpand(id);
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uriComponents.toUri());
		
		return new ResponseEntity<Void>(headers,HttpStatus.CREATED);
	}
	
	@GetMapping("/")
	public ResponseEntity<List<Student>> getAllStudents() {
		return ResponseEntity.ok(studentService.getAllStudents());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Student> getStudentById(@PathVariable("id") Long id){
		return ResponseEntity.ok(studentService.getStudentById(id));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteStudent(@PathVariable("id") Long id){
		studentService.deleteStudentById(id);
		return ResponseEntity.ok().build();
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Student> udpateStudent(@PathVariable("id") Long id, @Valid @RequestBody Student student) {
		return ResponseEntity.ok(studentService.updateStudent(student));
	}
}
