package com.app.test.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.test.dao.StudentRepository;
import com.app.test.model.Student;

@Service
public class StudentService {
	@Autowired
	private StudentRepository studentRepository;

	public List<Student> findAll() throws Exception {
		return studentRepository.findAll();
	}
	
	public Student findOne(Long studentId) throws Exception{
		return studentRepository.findOne(studentId);
	}
	
	public Student save(Student student) throws Exception{
		return studentRepository.save(student);
	}
	public Student update(Student student) {
		return studentRepository.save(student);
	}
	
	public Student partialUpdate(Student student) throws Exception{
		return studentRepository.save(student);
	}
	
	public void delete(Long studentId) throws Exception{
		Student student = studentRepository.findOne(studentId);
		studentRepository.delete(student);
	}
}
