package com.cs.util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SkillUtil {

	// Convert comma-separated string to normalized list (trimmed, case-insensitive
	// not applied)
	public static List<String> toList(String skills) {
		return Arrays.stream(skills.split("\s*,\s*")).collect(Collectors.toList());
	}

	// Check if student has all skills
	public static boolean hasAllSkills(List<String> studentSkills, String requiredSkills) {
		List<String> normalizedStudent = studentSkills.stream().map(String::trim).map(String::toLowerCase).toList();

		List<String> required = Arrays.stream(requiredSkills.split(",")).map(String::trim).map(String::toLowerCase)
				.toList();

		return normalizedStudent.containsAll(required);
	}
}
