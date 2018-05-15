package com.yllt.controller;

import org.apache.commons.lang3.StringUtils;

import com.alibaba.fastjson.JSONException;
import com.yllt.containers.ApplicationContext;
import com.yllt.containers.entity.SessionEntity;
import com.yllt.enumeration.CryptEnum;
import com.yllt.exception.ParamException;
import com.yllt.response.Response;
import com.yllt.utils.JsonUtil;
import com.yllt.utils.ValidateService;
import com.yllt.utils.crypto.CryptoManager;


public class BaseAct {
	
	/**
	 * 
	 * @param paramClass
	 * @param data
	 * @return
	 * @throws ParamException
	 * @throws JSONException
	 */
	protected Object getRequestParam(Class<?> paramClass, String data) throws ParamException, JSONException {
		Object paramResult = JsonUtil.parseObject(data, paramClass);
        Response response = ValidateService.validate(paramResult);
        if (null != response) {
            throw new ParamException(response);
        }
        return paramResult;
    }
	
	/**
	 * 根据用户进行已加密数据解密，并转为对应数据对象
	 * @param data
	 * @param paramClass
	 * @return
	 * @throws JSONException
	 * @throws ParamException
	 */
	protected Object decry(String data,Class<?> paramClass) throws JSONException, ParamException{
		
		if(StringUtils.isEmpty(data)){
			return null;
		}
		
		//获取当前登陆的用户数据
		SessionEntity sessionEntity = ApplicationContext.CTX.getSessionEntity();
		
		//取到key
		String key = sessionEntity.getToken();
		
		data = CryptoManager.getInstance().getCrypto(CryptEnum.AES).decrypt(data, key);
		
		if(StringUtils.isEmpty(data)){
			return null;
		}
		
		Object paramObject = getRequestParam(paramClass, data);
		
		return paramObject;
	}
}
