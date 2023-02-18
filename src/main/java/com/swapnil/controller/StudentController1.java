package com.swapnil.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.swapnil.DTO.StudentMarksDTO;
import com.swapnil.exception.StudentException;
import com.swapnil.model.Student;
import com.swapnil.service.StudentService;

@RestController
public class StudentController1 {

	@Autowired
	private StudentService studentService;
	
	
	@PostMapping("/register")
	public ResponseEntity<Student> reigsterStudent(@RequestBody Student student) throws StudentException{
		Student studen=studentService.registerStudent(student);
	
		return new ResponseEntity<Student>(studen,HttpStatus.CREATED);
	}
	@PutMapping("/addmarks")
	public ResponseEntity<Student> addMarksStudent(@RequestBody StudentMarksDTO student) throws StudentException{
		
		Student studen=studentService.addMarks(student);
	
		return new ResponseEntity<Student>(studen,HttpStatus.CREATED);
	}
	
}
