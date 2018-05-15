package com.yllt.service.test.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yllt.domain.test.Test1;
import com.yllt.mapper.test.Test1Mapper;
import com.yllt.service.BaseService;
import com.yllt.service.test.ITest1Service;

/**
 * 
 * <br>
 * <b>功能：</b>Test1ServiceImpl<br>
 * <b>作者：</b>Administrator<br>
 * <b>日期：</b> Wed Jan 06 16:30:01 CST 2016 <br>
 * <b>版权所有： 2015,hepo.com<br>
 */ 
@Service
@Transactional
public class Test1ServiceImpl extends BaseService<Test1> implements ITest1Service{
	private final static Logger log= Logger.getLogger(Test1ServiceImpl.class);
	

	

	@Autowired
    private Test1Mapper mapper;

		
	public Test1Mapper getMapper() {
		return mapper;
	}
	
	@Override
	public Integer insert(Test1 record) {
		mapper.insert(record);
		return record.getId();
	}
	

}
