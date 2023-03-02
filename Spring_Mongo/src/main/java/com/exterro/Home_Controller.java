package com.exterro;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Blob;
import java.util.List;

import javax.sql.rowset.serial.SerialBlob;

import org.apache.commons.io.IOUtils;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import com.exterro.services.StudentService;
import com.exterro.studentdocument.Student;

@RestController
public class Home_Controller {

	@Autowired
	private StudentService studentService;

	@GetMapping("/go")
	public ModelAndView showData() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("Register.html");

		return mv;
	}

	@PostMapping("/register")
	public ResponseEntity<Object> call(@RequestBody String val1) {
		System.out.println("inside controller");

		JSONParser jparse = new JSONParser();
		System.out.println("hi" + val1);
		JSONObject jobjects = new JSONObject();
		System.out.println("hi2");
		try {
			Object ob;
			System.out.println("hi3");
			ob = jparse.parse(val1);
			System.out.println("hi4");
			jobjects = (JSONObject) ob;
			System.out.println("hi5");
			String name = (String) jobjects.get("name");
			System.out.println("hi6");
			String mobile = (String) jobjects.get("mobile");
			String upload=(String)jobjects.get("upload");
			System.out.println(name);
			System.out.println(mobile);
			
			/*
			 * File file=new File(upload); FileInputStream fis = new FileInputStream(file);
			 * byte [] byteArray = IOUtils.toByteArray(fis); String streamreader = new
			 * String(byteArray);
			 */
			  byte[] blob = upload.getBytes();
		    
			Student student = new Student(name, mobile,blob);
			studentService.save(student);
			
		}

		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseEntity<Object>(jobjects, HttpStatus.OK);
	}

	@PostMapping("/jute")
	public ResponseEntity<List<Student>> getBooks(@RequestBody String val2) {
		System.out.println(val2);
		List<Student> Notes = null;
		Notes = studentService.findAll();
		return new ResponseEntity<List<Student>>(Notes, HttpStatus.CREATED);

	}

	@DeleteMapping("/delete/{id}")
	public String deleteBook(@PathVariable("id") String id) {
		studentService.deleteById(id);
		return "Deleted Successfully!!!";
	}

	@PutMapping("/update")
	public List<Student> updateCompanyDetail(@RequestBody Student data) {
		return studentService.update(data);
	}

}
