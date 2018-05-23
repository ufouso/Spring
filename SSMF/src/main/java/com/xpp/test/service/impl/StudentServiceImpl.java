package com.xpp.test.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xpp.test.dao.StudentDao;
import com.xpp.test.ioEntity.Student;
import com.xpp.test.service.StudentService;
import com.xpp.test.utils.LogUtil;

@Service
@Transactional
public class StudentServiceImpl implements StudentService {
	
	private Logger log = LoggerFactory.getLogger(getClass());
	
	@Resource
	private StudentDao dao;
	
	@Override
	public Student findByStuId(String id) {
		Student s =  dao.findById(id);
		log.info("student:"+s.toString());
		return s;
	}

	/**
	 * 添加学生
	 */
	@Transactional//事务回滚，(readOnly=true)提示数据库驱动程序和数据库系统，这个事务并不包含更改数据的操作，
								//	那么JDBC驱动程序和数据库就有可能根据这种情况对该事务进行一些特定的优化，
								//	比方说不安排相应的数据库锁，以减轻事务对数据库的压力，毕竟事务也是要消耗数据库的资源的。 
	@Override
	public void addStudent(Student s) {
		LogUtil.info("需要添加的学生信息："+s.toString());
		dao.addStudent(s);
//		String[] a = {"1","2"};
//		LogUtil.info(a[2]);//模拟异常
//		Student ss = new Student();
//		ss.setId("3");
//		ss.setName("王五");
//		ss.setAge("10");
//		dao.addStudent(ss);
	}

	/**
	 * 测试非RuntimeException异常的情况(事务回滚)，事务回滚正常情况下都是只回滚RuntimeException,CheckedException则不进行回滚，
	 * 如果非要回滚，如样例。
	 * @throws 
	 */
	@Transactional(rollbackFor=ClassNotFoundException.class)
	@Override
	public void updateStudent(Student s) throws ClassNotFoundException {
		dao.updateStudent(s);
//		Class.forName("aClass");//模拟ClassNotFoundException 
		Student ss = new Student();
		ss.setId("3");
		ss.setName("王五1");
		ss.setAge("10");
		dao.updateStudent(s);

	}
	
	/**
	 * 测试自定义异常
	 */
	@Override
	public void deleteStudent(String id){
		try {
			dao.deleteStudent(id);
//			String a[]={"1","2"};
			String faker = null;
			int a = faker.length();
			System.out.println(a);
		} catch (Exception e) {//交易异常如何获取错误信息；
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Student> getList() {
		return dao.findSome();
	}
}
