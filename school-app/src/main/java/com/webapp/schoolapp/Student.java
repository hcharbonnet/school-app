package com.webapp.schoolapp;

import jakarta.persistence.Entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity // Hibernate will recognize class as Entity and map to DB table
public class Student {
	@Id // Tells JPA this is primary key
	@GeneratedValue  // tells Hibernate we don't want to create this value ourself 
	private long id; 
	
	@Column(nullable = false)
	private String firstName;

	@Column(nullable = false)
	private String lastName;
	
	@Column(nullable = false)
	private Date birthDate;
	
	@Column(nullable = false)
	private String emailId;
	
	@Column(nullable = true)
	private int absences;
	
	@Column(nullable = true)
	private int tardy;
	
	@Column(nullable = true)
	private Standing standing;
	
	@Column(nullable = false)
	private String stringBirthDate;
	
	public Student() {
			
	}
	
	public Student(String firstName, String lastName, Date birthDate, String emailId, int absences, int tardy, Standing standing) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthDate = birthDate;
		this.emailId = emailId;
		this.absences = absences;
		this.tardy = tardy;
		this.standing = standing;
		this.stringBirthDate = "";
		
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public int getAbsences() {
		return absences;
	}
	public void setAbsences(int absences) {
		this.absences = absences;
	}
	public int getTardy() {
		return tardy;
	}
	public void setTardy(int tardy) {
		this.tardy = tardy;
	}
	public Standing getStanding() {
		return standing;
	}
	public void setStanding(Standing standing) {
		this.standing = standing;
	}
	public void setStringBirthDate(String stringBirthDate) {
		this.stringBirthDate = stringBirthDate;
	}
	public String getStringBirthDate() {
		return stringBirthDate;
	}
}
