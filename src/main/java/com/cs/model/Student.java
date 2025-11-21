package com.cs.model;

import java.util.List;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


public class Student {
	@NotBlank(message="Name Can not be blank")
	private String studentName;
	
	@Min(value = 0, message = "CGPA cannot be negative")
	@Max(value = 10, message = "CGPA cannot exceed 10")
	private double cgpa;
	
	@NotNull(message = "Skills cannot be null")
	@Size(min = 1, message = "At least one skill is required")
	private List<String> skills;
	
	public Student(String studentName, double cgpa, List<String> skills) {
		super();
		this.studentName = studentName;
		this.cgpa = cgpa;
		this.skills = skills;
	}

	public String getStudentName() {
		return studentName;
	}

	public double getCgpa() {
		return cgpa;
	}

	public List<String> getSkills() {
		return skills;
	}
}
