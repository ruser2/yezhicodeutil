package com.yllt.containers;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.yllt.containers.entity.SessionEntity;

/**
 * Created by Administrator on 2015/11/17.
 */
public class UserSessionContainer {
    //没有过期机制
    private Map<String, SessionEntity> sessionAndKeyMap = new HashMap<String, SessionEntity>();
    private static UserSessionContainer userSessionContainer;

    private UserSessionContainer() {
    }

    public static UserSessionContainer instance() {
        if (null == userSessionContainer) {
            synchronized (UserSessionContainer.class) {
                if (null == userSessionContainer) {
                    userSessionContainer = new UserSessionContainer();
                }
            }
        }
        return userSessionContainer;
    }

    public void put(String session, SessionEntity sessionEntity) {
    	//设置上一次操作时间
    	sessionEntity.setLastTime(new Date());
        sessionAndKeyMap.put(session, sessionEntity);
        
    }

    public SessionEntity get(String session) {
    	SessionEntity sessionEntity = sessionAndKeyMap.get(session);
    	//不过期返回数据，过期返回null 且清空原有数据
    	if(sessionEntity != null && sessionEntity.isExpired())
    		return sessionEntity;
    	else{
    		sessionAndKeyMap.remove(session);
    	}
    	return null;
    }
}
