package com.yllt.service.test.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yllt.domain.test.Test;
import com.yllt.mapper.BaseMapper;
import com.yllt.mapper.test.TestMapper;
import com.yllt.service.BaseService;
import com.yllt.service.test.ITestService;

@Service
@Transactional
public class TestServiceImpl extends BaseService<Test> implements ITestService{

	@Autowired
	private TestMapper mapper;
	
	@Override
	public BaseMapper<Test> getMapper() {
		return mapper;
	}
	

	@Override
	public Integer insert(Test record) {
		 getMapper().insert(record);
		 return record.getId();
	}

}
