package com.webapp.schoolapp;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.web.util.UriComponents;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

@Controller
public class ViewController {
	@Autowired
	private StudentService studentService;
	
	@GetMapping("/students")
	public String viewAllStudents(Model model) {
		List<Student> students = studentService.getAllStudents();
		model.addAttribute("students",students);
		System.out.println("view");
		return "all-students";
	}
	@GetMapping("/edit/{id}")
	public String editStudent(@PathVariable Long id, Model model) {
		System.out.println("edit");
		Student student = studentService.getStudentById(id);
		model.addAttribute("student", student);
		return "edit";
	}
	@PostMapping("/save")
	public String saveStudent(@ModelAttribute Student student) {
		System.out.println("save");
		studentService.updateStudent(student);
		return "redirect:/students";
	}
	@PostMapping("/remove/{id}")
	public String deleteStudent(@PathVariable Long id){
		System.out.println("delete");
		studentService.deleteStudentById(id);
		return "redirect:/students";
	}
}
