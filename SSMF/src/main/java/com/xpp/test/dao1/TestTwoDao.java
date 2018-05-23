package com.xpp.test.dao1;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;

import com.xpp.test.ioEntity.Train;

/**
 * 操作数据库testmirage
 * @author xpp
 *
 */
public interface TestTwoDao {
	
	@Insert("insert into train values (#{id}, #{owner}, #{sign})")
	public int addTrain(Train t);
	
	
	@Delete("delete from train where id=#{id}")
	public void delTrain(String id);
}
