package com.yllt.controller.job;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yllt.controller.BaseAct;
import com.yllt.service.job.IScheduleJobService;
 
/**
 * 
 * <br>
 * <b>功能：</b>ScheduleJobAct<br>
 * <b>作者：</b>Administrator<br>
 * <b>日期：</b> Thu Jan 07 10:28:20 CST 2016 <br>
 * <b>版权所有： 2016,yllt.com<br>
 */ 
@Controller
@RequestMapping("/scheduleJob") 
public class ScheduleJobAct extends BaseAct{
	
	private final static Logger logger= LoggerFactory.getLogger(ScheduleJobAct.class);
	
	@Autowired
	private IScheduleJobService scheduleJobService; 
	
}
