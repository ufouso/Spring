package com.xpp.test.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;

import com.xpp.test.ioEntity.Sedan;

/**
 * 操作数据库test
 * @author xpp
 *
 */
public interface TestOneDao {
	
	@Insert("insert into sedan values (#{id}, #{owner}, #{sign})")
	public int addSedan(Sedan s);
	
	@Delete("delete from sedan where id = #{id}")
	public void delSedan(String id);
}
