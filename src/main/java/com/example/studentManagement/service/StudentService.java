package com.example.studentManagement.service;

import org.springframework.stereotype.Service;

import com.example.studentManagement.model.StudentSchema;

import java.util.*;

@Service
public class StudentService {

	 private final List<StudentSchema> students = new ArrayList<>();
	 
	 private int nextId = 1; 
	 
	 public StudentService() {		 
		 students.add(new StudentSchema(nextId++, "RajKumar", "rajkumar1232@test.com", "Java"));  
		 students.add(new StudentSchema(nextId++, "Reena Singh", "reenasingh32@test.com", "React")); 		 
		 students.add(new StudentSchema(nextId++, "Kriti Kumari", "kirti2232@test.com", "Angular")); 
	 }
	 
	 public List<StudentSchema> getAllStudents(){
		 return students; 
	 }
	
	 public StudentSchema getStudentById(int id) {	 
		 for(StudentSchema student:  students ) {
			 if(student.getId() == id) {
				 return student;
			 }
		 }
		 return null;
	 }
	 
	 
	 public void addStudent(StudentSchema student) {
		 student.setId(nextId++);
		 students.add(student);
	 }
	 
	 
	 public boolean updateStudent(int id, StudentSchema updatedStudent) {
		 StudentSchema existingStudent = getStudentById(id);
		 
		 if(existingStudent == null) {
			 return false; 
         }
		 existingStudent.setName(updatedStudent.getName());
		 existingStudent.setEmail(updatedStudent.getEmail());
		 existingStudent.setCourse(updatedStudent.getCourse());
		 
		 return true;
	 }
	 
	 
	 public boolean deleteStudent(int id) {
		 return students.removeIf(student -> student.getId() == id);
	 }
	 
	 
	
}
