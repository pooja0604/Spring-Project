package com.app.test.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.app.test.model.Student;
import com.app.test.service.StudentService;

@RestController
@RequestMapping("students") // http://localhost:8080/students
@CrossOrigin(origins= {"http:localhost:4200"})

public class StudentController {
	
	@Autowired
	private StudentService studentService;

	@RequestMapping(method = RequestMethod.GET)
	public List<Student> getAll() throws Exception {
		return studentService.findAll();
	}

	@RequestMapping(method = RequestMethod.GET, value="/{studentId}")
	public Student getStudentBystudentId(@PathVariable("studentId") Long studentId) throws Exception {
		return studentService.findOne(studentId);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Student> create(@Valid @RequestBody Student student) throws Exception {
		return new ResponseEntity<Student>(studentService.save(student), HttpStatus.CREATED);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/{studentId}")
	public Student update(@PathVariable("studentId") Long studentId,@RequestBody Student student) throws Exception {
		student.setStudentId(studentId);
		return studentService.update(student);
	}
	
	@RequestMapping(method = RequestMethod.PATCH ,value="/{studentId}")
	public Student partialUpdate(@PathVariable("studentId")Long studentId, @RequestBody Student student) throws Exception{
		student.setStudentId(studentId);
		return studentService.partialUpdate(student);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/{studentId}")
	public ResponseEntity<HttpStatus> delete(@PathVariable("studentId") Long studentId) throws Exception {
		studentService.delete(studentId);
		return  new ResponseEntity<HttpStatus>(HttpStatus.OK) ;
	}

}

