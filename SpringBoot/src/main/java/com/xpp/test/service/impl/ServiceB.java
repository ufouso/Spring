package com.xpp.test.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.xpp.test.domain.Student;
import com.xpp.test.repository.StudentRepository;

@Component
public class ServiceB {
	
	@Autowired
	private StudentRepository repositories;
	
	@Transactional
	public void methodB(String age) {
		Student s = new Student();
		s.setAge(age);
		repositories.save(s);
		String a = null;
		a.length();
	}
}
