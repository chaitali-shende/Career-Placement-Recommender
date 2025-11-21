package com.cs.strategy;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.cs.model.Student;
import com.cs.util.ConsoleColors;
import com.cs.util.SkillUtil;

@Component("itStrategy")
public class ITPlacementStrategy implements PlacementStrategy {
	@Value("${it.minCgpa}")
	private double minCgpa;

	@Value("${it.requiredSkills}")
	private String requiredSkills;

	@Value("${it.baseSalary}")
	private double baseSalary;

	@Override
	public String recommendPlacement(Student student) {
		  if (student.getCgpa() < minCgpa)
	            return ConsoleColors.RED_BOLD +"Selected Strategy: IT Placement \nEligible: NO (CGPA below requirement)";

	        boolean skillMatch = SkillUtil.hasAllSkills(student.getSkills(), requiredSkills);

	        if (!skillMatch)
	            return ConsoleColors.RED_BOLD +"Selected Strategy: IT Placement \nEligible: NO (Missing Skills → "
	                    + requiredSkills.replace(",", ", ") + ")";

	        double bonusFactor = 10000.0;
	        double salary = baseSalary + (student.getCgpa() * bonusFactor);

	        return """
	                ===== IT Placement Result =====
	                Name: %s
	                Eligible: YES
	                Salary Offered: %.2f
	                Required Skills: %s
	                """
	        		.formatted(
	                        student.getStudentName(),
	                        salary,
	                        requiredSkills.replace(",", ", ")
	                );
	}
}
