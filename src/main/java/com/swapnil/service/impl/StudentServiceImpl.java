package com.swapnil.service.impl;

import java.util.ArrayList;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.swapnil.DTO.StudentMarksDTO;

import com.swapnil.Repository.StudentDAO;

import com.swapnil.exception.StudentException;

import com.swapnil.model.Student;
import com.swapnil.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService{
	
	@Autowired
	private StudentDAO studentDao;
	
	@Override
	public Student registerStudent(Student student) throws StudentException {
		
		Optional<Student> studentOpt=studentDao.findById(student.getRoll());
		if(studentOpt.isPresent()) {
			throw new StudentException("Student already present");
		}
		return studentDao.save(student);
	
	}

	@Override
	public Student addMarks(StudentMarksDTO studentMarks) throws StudentException{
		Optional<Student> studentOpt=studentDao.findById(studentMarks.getRoll());
		if(studentOpt.isPresent()) {
			Student student=studentOpt.get();
			if(studentMarks.getSemesterNo()==1) {
				if(studentMarks.getSubject().toLowerCase().equals("english")) {
					student.setEnglish1(studentMarks.getMarks());
				}else if(studentMarks.getSubject().toLowerCase().equals("math")) {
					student.setMath1(studentMarks.getMarks());
				}else if(studentMarks.getSubject().toLowerCase().equals("science")) {
					student.setScience1(studentMarks.getMarks());
				}else {
					throw new StudentException("subject not present");
				}
			}else if (studentMarks.getSemesterNo()==2) {
				if(studentMarks.getSubject().toLowerCase().equals("english")) {
					student.setEnglish1(studentMarks.getMarks());
				}else if(studentMarks.getSubject().toLowerCase().equals("math")) {
					student.setMath2(studentMarks.getMarks());
				}else if(studentMarks.getSubject().toLowerCase().equals("science")) {
					student.setScience2(studentMarks.getMarks());
				}else {
					throw new StudentException("subject not present");
				}
			}else {
				throw new StudentException("There is no semester");
			}
			
			
			return studentDao.save(student);
		}
		throw new StudentException("Student not present");

	
	}

	@Override
	public Student getStudent(Integer roll) throws StudentException {
		
		Optional<Student> studentOpt=studentDao.findById(roll);
		if(studentOpt.isPresent()) {
			return studentOpt.get();
		}
		
		throw new StudentException("Student not present");
		
	}

	@Override
	public List<Student> getAllStudent() throws StudentException {
		
		Iterable<Student> stuIter=studentDao.findAll();
		
		List<Student> students= new ArrayList<>();
		
		stuIter.forEach(students::add);
		 if(students.isEmpty()) {
			 throw new StudentException("Students not present");
		 }
		return students;
	}

}
