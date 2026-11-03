package com.example.studentManagement.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.studentManagement.model.StudentSchema;
import com.example.studentManagement.service.StudentService;

@Controller
public class StudentController {

	private final StudentService service;
	
	public StudentController( StudentService service) {
		this.service = service; 
	}
	
	@GetMapping("/")
	  public String home() {
		 return "redirect:/students";
	}
	
	@GetMapping("/students")
	  public String getAllStudents(Model model) {
		  model.addAttribute("students", service.getAllStudents());
		  
		  return "student-list";
	}
	
	@GetMapping("/students/new")
	    public String showAddForm(Model model) {
		
		  model.addAttribute("student", new StudentSchema());
		  model.addAttribute("pageTitle", "Add Student"); 
		  
		  return "student-form";
	}
	
	@PostMapping("/students/save")
	   public String saveStudent(
		   StudentSchema student) {
		   
		   if(student.getId() == 0) {
			   service.addStudent(student);
		   }else {
			   service.updateStudent(student.getId(), student);
		   }
		   
		   return "redirect:/students";
		   
	}
	
	@GetMapping("/students/edit/{id}")
	    public String showEditForm( @PathVariable int id, Model model) {
		   
		StudentSchema student = service.getStudentById(id);
		
		if(student == null) {
			return "redirect:/students";
		}
		
		model.addAttribute("student", student);
		model.addAttribute("pageTitle", "Edit Student");
		
		return "student-form";

	}
	
	
	 @GetMapping("/students/view/{id}")
	    public String viewStudent( @PathVariable int id, Model model) {
		 
		 StudentSchema student = service.getStudentById(id);
		 
		 if(student == null) {
			 return "redirect:/students"; 
		 }
		  
		 model.addAttribute("student", student);
		 return "student-view";
	 }
	 
	 
	 @GetMapping("students/delete/{id}")
	   public String deleteStudent(@PathVariable int id) {
		  
		    service.deleteStudent(id);
		    return "redirect:/students";
	 }
	    
	    
	    
	    
	    
	    
	    
	    
	    
}
