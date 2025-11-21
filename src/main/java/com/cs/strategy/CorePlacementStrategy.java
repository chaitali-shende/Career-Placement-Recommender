package com.cs.strategy;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.cs.model.Student;
import com.cs.util.ConsoleColors;
import com.cs.util.SkillUtil;

@Component("coreStrategy")
public class CorePlacementStrategy implements PlacementStrategy {
	@Value("${core.minCgpa}")
	private double minCgpa;
	
	@Value("${core.requiredSkills}")
	private String requiredSkills;
	
	@Value("${core.salary}")
	private double salary;
	
	@Override
	public String recommendPlacement(Student student) {
		  if (student.getCgpa() < minCgpa)
	            return ConsoleColors.RED_BOLD +"Selected Strategy: Core Placement \nEligible: NO (CGPA below requirement)";

	        boolean skillMatch = SkillUtil.hasAllSkills(student.getSkills(), requiredSkills);

	        if (!skillMatch)
	            return ConsoleColors.RED_BOLD +"Selected Strategy: Core Placement \nEligible: NO (Missing Skills → "
	                    + requiredSkills.replace(",", ", ") + ")";

	        return """
	                ===== Core Placement Result =====
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
