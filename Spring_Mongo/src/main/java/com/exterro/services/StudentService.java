package com.exterro.services;

import java.util.List;

import com.exterro.studentdocument.Student;


public interface StudentService {


    public void deleteById(String id);

	public void save(Student student);

	public List<Student> findAll();

	public List<Student> update(Student data);

	
}
