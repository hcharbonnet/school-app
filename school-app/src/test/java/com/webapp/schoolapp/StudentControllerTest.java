package com.webapp.schoolapp;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.springframework.http.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@ExtendWith(SpringExtension.class)
@WebMvcTest(StudentController.class)
public class StudentControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	private ObjectMapper objectMapper;
	
	@MockBean
	private StudentService studentService; 
	
	@Captor
	private ArgumentCaptor<Student> argumentCaptor;
	
	@Test
	public void postMethodCreatesNewStudent() throws JsonProcessingException, Exception {
		Student student = new Student(); 
		student.setId(0L);
		student.setFirstName("Caroline");
		student.setLastName("G");
		student.setEmailId("c@mail.com");
		when(studentService.createNewStudent(argumentCaptor.capture())).thenReturn(0L);
		
		this.mockMvc.perform(post("/api/students")
				.contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(student)))
				.andExpect(status().isCreated())
				.andExpect(header().exists("Location"))
				.andExpect(header().string("Location","http://localhost/api/students/0"));
		
		assertThat(argumentCaptor.getValue().getFirstName(), is("Caroline"));
		assertThat(argumentCaptor.getValue().getLastName(), is("G"));
		assertThat(argumentCaptor.getValue().getEmailId(), is("c@mail.com"));
	}
	
	public void getMethodReturnsAllStudents() throws JsonProcessingException, Exception {
		Student student = new Student(); 
		student.setId(0L);
		student.setFirstName("Caroline");
		student.setLastName("G");
		student.setEmailId("c@mail.com");
		when(studentService.createNewStudent(argumentCaptor.capture())).thenReturn(0L);
		
		this.mockMvc.perform(post("/api/students")
				.contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(student)))
				.andExpect(status().isCreated())
				.andExpect(header().exists("Location"))
				.andExpect(header().string("Location","http://localhost/api/students/0"));
		
		assertThat(argumentCaptor.getValue().getFirstName(), is("Caroline"));
		assertThat(argumentCaptor.getValue().getLastName(), is("G"));
		assertThat(argumentCaptor.getValue().getEmailId(), is("c@mail.com"));
	}
	
}
