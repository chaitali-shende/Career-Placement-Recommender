package com.cs.config;

import javax.validation.Validation;
import javax.validation.Validator;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(basePackages = "com.cs")
@PropertySource("com/cs/commons/Placement.properties")
public class AppConfig {
	 @Bean
	    public Validator validator() {
	        return Validation.buildDefaultValidatorFactory().getValidator();
	    }
}
