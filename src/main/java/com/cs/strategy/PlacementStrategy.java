package com.cs.strategy;

import com.cs.model.Student;

public interface PlacementStrategy {
	String recommendPlacement(Student student);
}
