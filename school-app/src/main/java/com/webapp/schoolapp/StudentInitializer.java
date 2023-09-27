package com.webapp.schoolapp;

import com.webapp.schoolapp.StudentRepository;
import com.webapp.schoolapp.Student;
import org.springframework.boot.CommandLineRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StudentInitializer implements CommandLineRunner{
	
	@Autowired
	private StudentRepository studentRepository;
	
	
	@Override
	public void run(String... args) throws Exception {
		System.out.println("Creating sample data...");
		
		String[] firstNames = {"Helen","Julie","Nate","Carolina","Meghan","Alex","Pooja","Neela","Navi","Pierre"};
		String[] lastNames = {"C","D","G","B","W","Y","F","K","A","S"};
		String[] emails = {"C@mail.com","D@mail.com","G@mail.com","B@mail.net","W@mail.edu","Y@mail.edu","F@mail.gov","K@mail.com","A@mail.net","S@mail.co"};
		Integer[] abscences = {1,2,6,1,0,3,4,0,0,1};
		Integer[] bonusPts = {1,2,6,1,0,3,4,0,0,1};
		String[] standing = {"Exceeds Expectations","Meets Expectations","Meets Few Expectations","Fails to Meet Expectations","Exceeds Expectations","Meets Expectations","Meets Expectations","Meets Expectations","Meets Expectations","Meets Expectations"};
		for(int i=0; i<firstNames.length; i++) {
			Student student = new Student(firstNames[i],lastNames[i],emails[i], abscences[i], bonusPts[i], standing[i]);
			studentRepository.save(student);
		}

		System.out.println("Data created.");
	}
}