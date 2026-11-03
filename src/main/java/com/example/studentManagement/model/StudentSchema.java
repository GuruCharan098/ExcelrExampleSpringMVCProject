package com.example.studentManagement.model;

public class StudentSchema {

	       private int id; 
	       private String name; 
	       private String email; 
	       private String course;
	       
	       public StudentSchema() {
	    	   
	       }
	       
	       public StudentSchema (int id, String name, String email, String course) {
	    	     this.id = id; 
	    	     this.name = name; 
	    	     this.email = email; 
	    	     this.course = course;
	       }
	       
	       
	       //Getter
	              
	       public int getId() {
	    	   return id; 
	       }
	       
	       public String getName() {
	    	   return name; 
	       }
	       
	       public String getEmail() {
	    	   return email; 
	       }
	       
	       public String getCourse() {
	    	   return course; 
	       }
	       
	       // Setter
	       
	       public void setId(int id) {
	    	   this.id = id; 
	       }
	       
	       public void setName(String name) {
	    	   this.name = name; 
	       }
	       
	       public void setEmail(String email) {
	    	   this.email = email; 
	       }
	       
	       public void setCourse(String course) {
	    	   this.course = course; 
	       }
	       
	       
	       
}
