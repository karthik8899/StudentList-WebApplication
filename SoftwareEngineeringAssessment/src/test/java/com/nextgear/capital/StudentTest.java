package com.nextgear.capital;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;

import com.nextgear.capital.student.Student;
import com.nextgear.capital.student.StudentService;

public class StudentTest {

	  static List<Student> studentList = new ArrayList<Student>();

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		Student student = new Student();
		student.id=120L;
		student.name="Testing";
		student.age="100";
	 	   studentList.add(student);
		
		
	}



	@Test
	public void test() {
		
		StudentService studentService = Mockito.mock(StudentService.class);

	        // define return value for method getUniqueId()
	        when(studentService.getAllStudents()).thenReturn(studentList);
	        
	        
		if(studentService !=null)
		assertTrue(!studentService.getAllStudents().isEmpty());
	}

}
