package com.webapp.schoolapp;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.web.util.UriComponents;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
	
	@ModelAttribute("standings")
	public Standing[] standing() {
		return Standing.values();
	}
	
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
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		student.setStringBirthDate(dateFormat.format(student.getBirthDate()));
		model.addAttribute("student", student);
		return "edit";
	}
	@PostMapping("/save")
	public String saveStudent(@RequestParam("stringBirthDate") String dateString, @ModelAttribute Student student) {
		System.out.println("save");
		try {
			SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
			Date dateOfBirth = dateFormat.parse(dateString);
			student.setBirthDate(dateOfBirth);

		} catch (ParseException e) {
			return "error";
		}
		studentService.updateStudent(student);
		return "redirect:/students";
	}
	
	@GetMapping("/add")
	public String showAddPage(Model model) {
		Student student = new Student();
		model.addAttribute("student", student);
		System.out.println("add");
		return "add";  
	}
	@PostMapping("/add")
	public String saveNewStudent(@RequestParam("stringBirthDate") String dateString, @ModelAttribute Student student) {
		System.out.println("adding");
		try {
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			Date dateOfBirth = dateFormat.parse(dateString);
			student.setBirthDate(dateOfBirth);
		} catch (ParseException e) {
			return "error";
		}
		studentService.createNewStudent(student);
		System.out.println("added");
		return "redirect:/students";
	}

	@PostMapping("/remove/{id}")
	public String deleteStudent(@PathVariable Long id){
		System.out.println("delete");
		studentService.deleteStudentById(id);
		return "redirect:/students";
	}
}
