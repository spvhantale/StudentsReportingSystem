package com.swapnil.service;

import java.util.List;


import com.swapnil.DTO.StudentMarksDTO;
import com.swapnil.exception.StudentException;
import com.swapnil.model.Student;


public interface StudentService {

	public Student registerStudent(Student student)throws StudentException;
	
	public Student addMarks(StudentMarksDTO studentMarks) throws StudentException;
	
	public Student getStudent(Integer roll) throws StudentException;
	
	public List<Student> getAllStudent() throws StudentException;
	
	
	
}
