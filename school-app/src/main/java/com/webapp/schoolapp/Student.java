package com.webapp.schoolapp;

import jakarta.persistence.Entity;
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
	private String emailId;
	
	@Column(nullable = true)
	private int absences;
	
	@Column(nullable = true)
	private int bonusPts;
	
	@Column(nullable = true)
	private String standing;
	
	
	public Student() {
			
	}
	
	public Student(String firstName, String lastName, String emailId, int absences, int bonusPts, String standing) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailId = emailId;
		this.absences = absences;
		this.bonusPts = bonusPts;
		this.standing = standing;
		
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
	public int getBonusPts() {
		return bonusPts;
	}
	public void setBonusPts(int bonusPts) {
		this.bonusPts = bonusPts;
	}
	public String getStanding() {
		return standing;
	}
	public void setStanding(String standing) {
		this.standing = standing;
	}
}
