package com.xpp.test.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.xpp.test.dao.TestOneDao;
import com.xpp.test.dao1.TestTwoDao;
import com.xpp.test.ioEntity.Sedan;
import com.xpp.test.ioEntity.Train;
import com.xpp.test.service.TestService;


@Service
public class TestServiceImpl implements TestService {
	
	@Autowired
	private TestOneDao dao1;
	
	@Autowired
	private TestTwoDao dao2;
	
	
	/**
	 * 同时对数据库test 和数据库testmirage进行添加数据。
	 * 之后中间添加异常，查看两个数据库的数据是否回滚
	 */
	@Transactional(propagation=Propagation.REQUIRED, rollbackForClassName="Exception")
	@Override
	public int insertAll() {
		try {
			Train t = new Train();
			t.setId("1");
			t.setOwner("jerry");
			t.setSign("HS");
			dao2.addTrain(t);
		
			Sedan s = new Sedan();
			s.setId("1");
			s.setOwner("Tom");
			s.setSign("Benz");
			dao1.addSedan(s);
		} catch (Exception e) {
//			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			throw new RuntimeException();
//			e.printStackTrace();
		}
		return 0;
	}

	public void deleteAll(String id1, String id2) {
		dao1.delSedan(id1);
		String a=null;
		a.length();
		dao2.delTrain(id2);
	}

}
