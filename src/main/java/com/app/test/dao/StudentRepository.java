package com.app.test.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.test.model.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

}
