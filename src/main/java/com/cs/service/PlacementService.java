package com.cs.service;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cs.model.Student;
import com.cs.strategy.CorePlacementStrategy;
import com.cs.strategy.FinancePlacementStrategy;
import com.cs.strategy.ITPlacementStrategy;
import com.cs.strategy.ManagementPlacementStrategy;
import com.cs.strategy.PlacementStrategy;
import com.cs.util.ConsoleColors;

@Service
public class PlacementService {
	
    private Validator validator;
    private final Map<String, PlacementStrategy> strategyMap = new HashMap<>();

    @Autowired
    public PlacementService(
            ITPlacementStrategy it,
            CorePlacementStrategy core,
            ManagementPlacementStrategy mgmt,
            FinancePlacementStrategy finance) {

        strategyMap.put("it", it);
        strategyMap.put("core", core);
        strategyMap.put("mgmt", mgmt);
        strategyMap.put("finance", finance);

        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        this.validator = factory.getValidator();
    }

    public PlacementStrategy getStrategyByType(String type) {
        return strategyMap.getOrDefault(type.toLowerCase(), strategyMap.get("it"));
    }

    public String executeStrategy(PlacementStrategy strategy, Student student) {

        var violations = validator.validate(student);
        if (!violations.isEmpty()) {
            StringBuilder sb = new StringBuilder(ConsoleColors.RED_BOLD +"Validation Errors:\n");
            violations.forEach(v -> sb.append(v.getMessage()).append("\n"));
            return sb.toString();
        }
        return strategy.recommendPlacement(student);
    }
}
