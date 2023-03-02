package com.exterro.studentdocument;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exterro.services.StudentService;
@Service
public class Imple_Student_Service implements StudentService {
	  @Autowired
	    private StudentRepository studentRepo;

	    @Override
	    public void save(Student student) {
	    	System.out.println(student);
	    	studentRepo.save(student);
	        
	    }

	    @Override
	    public void deleteById(String id) {
	        studentRepo.deleteById(id);
	        
	    }


		@Override
		public List<Student> findAll() {
	        return studentRepo.findAll();
		}
		
		@Override
		public List<Student> update( Student data) {
			 Student dataToBeUpdate =studentRepo.findById((data.getId())).get();
			  dataToBeUpdate.setName(data.getName());
			  dataToBeUpdate.setMobile(data.getMobile());
			  studentRepo.delete(data);
			  studentRepo.insert(dataToBeUpdate);
			  return studentRepo.findAll();
		}
			
		}



