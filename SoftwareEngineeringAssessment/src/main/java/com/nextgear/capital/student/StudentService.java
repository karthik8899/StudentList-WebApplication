package com.nextgear.capital.student;

import java.util.ArrayList;
import java.util.List;

import org.springframework.aop.ThrowsAdvice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
	
	@Autowired
	private StudentRepository studentRepository;
	
	public List<Student> getAllStudents(){
		List<Student> students = new ArrayList<>();
		studentRepository.findAll().forEach(students::add);
		return students;
	}
	
	public void addStudent(Student student) throws Exception{
			studentRepository.save(student);
	}
	
	public void delete(Long id){
		studentRepository.delete(id);
	}
}
