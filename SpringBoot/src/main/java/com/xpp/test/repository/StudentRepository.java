package com.xpp.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.xpp.test.domain.Student;

public interface StudentRepository extends JpaRepository<Student, Integer>{

	Student findOne(int i);
	
}
