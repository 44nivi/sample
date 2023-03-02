package com.exterro.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.exterro.services.StudentService;
import com.exterro.studentdocument.Imple_Student_Service;

@Configuration
public class AppConfig {

	@Bean 
	public StudentService studentService() {
		return new Imple_Student_Service();
	}}

