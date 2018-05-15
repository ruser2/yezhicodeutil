package com.yllt.controller.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yllt.controller.BaseAct;
import com.yllt.service.test.ITest1Service;
 
/**
 * 
 * <br>
 * <b>功能：</b>Test1Act<br>
 * <b>作者：</b>Administrator<br>
 * <b>日期：</b> Wed Jan 06 16:30:01 CST 2016 <br>
 * <b>版权所有： 2015,hepo.com<br>
 */ 
@Controller
@RequestMapping("/test1") 
public class Test1Act extends BaseAct{
	
	private final static Logger logger= LoggerFactory.getLogger(Test1Act.class);
	
	@Autowired
	private ITest1Service test1Service; 
	
}
