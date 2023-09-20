package com.webapp.schoolapp;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;


public class StudentRequest {
	@NotEmpty
	@Size(max= 20)
	private String firstName;
	@NotEmpty
	private String lastName;
	@NotEmpty
	private String emailId;

}
