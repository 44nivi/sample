package com.exterro.studentdocument;

import java.sql.Blob;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="Student")
public class Student {


	 	@Id
	    private String id;
	 	
	    private String name;
	    private String mobile;
	    private byte[] blob;
	    
	    
	   

		public byte[] getBlob() {
			return blob;
		}

		public void setBlob(byte[] blob) {
			this.blob = blob;
		}

		
		public String getName() {
	        return name;
	    }

	    public void setName(String name) {
	        this.name = name;
	    }

	    public String getMobile() {
	        return mobile;
	    }

	    public void setMobile(String mobile) {
	        this.mobile = mobile;
	    }

	    public Student(String name, String mobile,byte[] blob) {
	        super();
	        this.name = name;
	        this.mobile = mobile;
	        this.blob=blob;
	    }


		public String getId() {
	        return id;
	    }

	    public void setId(String id) {
	        this.id = id;
	    }

		

}
