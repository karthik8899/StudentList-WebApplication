package com.nextgear.capital.student;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	@RequestMapping("/getStudents")
	public List<Student> getAllStudents(){
		return studentService.getAllStudents();
	}


	
	@RequestMapping(value="/insertStudents", method=RequestMethod.POST)
	public void addStudent(@RequestBody List<Student> students){
		for(Student student: students){
			try {
				studentService.addStudent(student);
			} catch (Exception e) {
				
				e.printStackTrace();
			}	
		}
	
	}

	@RequestMapping(value="/deleteStudents/{id}", method=RequestMethod.DELETE)
	public void removeStudent(@PathVariable Long id){
		studentService.delete(id);
	}

	@RequestMapping(value="/updateStudents", method=RequestMethod.PUT)
	public void updateStudent(@RequestBody Student student){
		try {
			studentService.addStudent(student);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	
}
