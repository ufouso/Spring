package com.xpp.test.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xpp.test.domain.Student;
import com.xpp.test.repository.StudentRepository;
import com.xpp.test.service.ServiceA;

@Service
//@Transactional
public class ServiceAImpl implements ServiceA {
	
	@Autowired
	private StudentRepository repositories;
	
	@Autowired
	private ServiceB serviceB;
	
	@Transactional
	@Override
	public void methodA() {
		try {
			Student s = new Student();
			s.setId(1);
			s.setAge("1");
			repositories.save(s);
			//调用外部的方法。
			for(int i=0;i<5;i++){
				//循环都是用的同一个事务。
				//因为外部方法上面添加了事务，所以这5个循环用的也是同一个事务
				//如果外部方法上面没有添加事务，但是操作数据库JPA的save方法源码上有事务，
				//所以操作数据库的是一个事务，但是如果外部方法内的其他部分出现了异常，只会回滚外部方法的，而本方法的不会回滚。
				serviceB.methodB("age"+i);
			}
			String b = null;
			b.length();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
