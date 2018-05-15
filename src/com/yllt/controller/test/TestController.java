//package com.yllt.controller.test;
//
//import java.io.UnsupportedEncodingException;
//import java.util.HashMap;
//import java.util.List;
//
//import javax.servlet.http.HttpServletRequest;
//
//import org.apache.commons.lang3.StringUtils;
//import org.quartz.SchedulerException;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import com.alibaba.fastjson.JSONException;
//import com.alibaba.fastjson.JSONObject;
//import com.yllt.containers.ApplicationContext;
//import com.yllt.containers.UserSessionContainer;
//import com.yllt.containers.entity.SessionEntity;
//import com.yllt.containers.entity.UserInfo;
//import com.yllt.controller.BaseAct;
//import com.yllt.domain.job.ScheduleJob;
//import com.yllt.domain.test.Test;
//import com.yllt.enumeration.CryptEnum;
//import com.yllt.exception.ParamException;
//import com.yllt.param.RequestParam;
//import com.yllt.response.Response;
//import com.yllt.service.job.IJobService;
//import com.yllt.service.test.ITestService;
//import com.yllt.service.test.param.TestAddParam;
//import com.yllt.utils.Base64Utils;
//import com.yllt.utils.crypto.CryptoManager;
//
//@Controller
//@RequestMapping("test")
//public class TestController extends BaseAct{
//
//	private static final Logger LOGGER = LoggerFactory.getLogger(TestController.class);
//	
//	@Autowired
//	private ITestService testService;
//	
//	@ResponseBody
//	@RequestMapping(value="index")
//	public Response index(RequestParam requestParam,HttpServletRequest request){
//		try {
//			TestAddParam param = (TestAddParam) decry(requestParam.getData(), TestAddParam.class);
//			
//			List<Test> list = testService.queryList(new HashMap<String, Object>());
//			System.out.println();
//		} catch (JSONException e) {
//			e.printStackTrace();
//		} catch (ParamException e) {
//			LOGGER.error("请求参数有误");
//			return e.getResponse();
//		}
//		
//		JSONObject jsonObject = new JSONObject();
//		jsonObject.put("name", "123");
//		jsonObject.put("id", "123");
//		
//		Test test = new Test();
//		test.setName("1233");
//		
//		Response response = new Response(jsonObject);
//		
//		testService.insert(test);
//		
//		//添加定时任务
//		ScheduleJob job1 = new ScheduleJob();
//		job1.setJobName("job1");
//		job1.setJobGroup("jobGroup1");
//		job1.setSpringId("testJob");
//		job1.setMethodName("excue");
//		job1.setCronExpression("0/5 * * * * ?");
//		job1.setJobStatus(ScheduleJob.STATUS_RUNNING);
//		
//		try {
//			jobService.deleteJob(job1);
//			jobService.addJob(job1);
//		} catch (SchedulerException e) {
//			e.printStackTrace();
//		}
//		
//		
//		return null;
//	}
//	
//	/**
//	 * 模拟登陆
//	 * @throws UnsupportedEncodingException
//	 */
//	@ResponseBody
//	@RequestMapping("login")
//	public void login() throws UnsupportedEncodingException{
//		JSONObject jsonObject = new JSONObject();
//		jsonObject.put("token", "7613e58bd9bc40e4");
//		jsonObject.put("user", "123456");
//		
//		SessionEntity sessionEntity = new SessionEntity();
//		sessionEntity.setEncryptKey("7613e58bd9bc40e4");
//		sessionEntity.setToken("7613e58bd9bc40e4");
//		
//		UserInfo userInfo = new UserInfo();
//		userInfo.setUserId("1");
//		userInfo.setUserName("username");
//		
//		sessionEntity.setUserInfo(userInfo);
//		
//		UserSessionContainer.instance().put("123456", sessionEntity);
//		
//		System.out.println("session=" + jsonObject.toJSONString());
//		System.out.println("session=" + Base64Utils.encode(jsonObject.toJSONString().getBytes("UTF-8")));
//	}
//	
//}
