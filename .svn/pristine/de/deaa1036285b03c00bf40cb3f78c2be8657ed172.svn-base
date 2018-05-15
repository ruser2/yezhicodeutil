package com.yllt.service.job.impl;

import org.apache.log4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yllt.domain.job.ScheduleJob;
import com.yllt.service.BaseService;
import com.yllt.mapper.job.ScheduleJobMapper;
import com.yllt.service.job.IScheduleJobService;

/**
 * 
 * <br>
 * <b>功能：</b>ScheduleJobServiceImpl<br>
 * <b>作者：</b>Administrator<br>
 * <b>日期：</b> Thu Jan 07 10:28:20 CST 2016 <br>
 * <b>版权所有： 2016,yllt.com<br>
 */ 
@Service
@Transactional
public class ScheduleJobServiceImpl extends BaseService<ScheduleJob> implements IScheduleJobService{
	private final static Logger log= Logger.getLogger(ScheduleJobServiceImpl.class);

	@Autowired
    private ScheduleJobMapper mapper;

		
	public ScheduleJobMapper getMapper() {
		return mapper;
	}
	
	@Override
	public Integer insert(ScheduleJob record) {
		mapper.insert(record);
		return record.getId();
	}
	

}
