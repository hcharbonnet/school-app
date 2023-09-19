package com.webapp.schoolapp;

import com.webapp.schoolapp.StudentRepository;
import com.webapp.schoolapp.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StudentInitializer implements CommandLineRunner{
	
	@Autowired
	private StudentRepository studentRepository;
	
	
	@Override
	public void run(String... args) throws Exception {
		System.out.println("Creating sample data...");

		Student stud1 = new Student("Helen","C","h@mail.com");
		studentRepository.save(stud1);
		Student stud2 = new Student("Nate", "A", "n@mail.com");
		studentRepository.save(stud2);
		Student stud3 = new Student("Julia","B", "j@mail.com");
		studentRepository.save(stud3);
		System.out.println("Data created.");
	}
}