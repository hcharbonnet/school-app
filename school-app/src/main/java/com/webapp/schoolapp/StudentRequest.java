package com.webapp.schoolapp;

import lombok.Data;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
public class StudentRequest {
	@NotEmpty
	@Size(max= 20)
	private String firstName;
	@NotEmpty
	private String lastName;
	@NotEmpty
	private String email_id;

}
