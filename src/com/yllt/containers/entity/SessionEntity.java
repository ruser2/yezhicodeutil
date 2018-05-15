package com.yllt.containers.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import cn.ffcs.zq.util.DateUtils;

/**
 *
 * @author nelson
 */
public class SessionEntity {
    private String encryptKey;
    private UserInfo userInfo;
    //存放于session中，用户请求时会附带token，做一致性验证
    private String token;
    //上一次操作时间
    private Date lastTime;
    private Long liveTime;
    
    private Set<String> privilegeSets  = new HashSet<String>(0);
    
    //默认有效期30分钟
    public static final Long DEFAULT_LIVE_TIME = 30l;

    public String getEncryptKey() {
        return encryptKey;
    }

    public void setEncryptKey(String encryptKey) {
        this.encryptKey = encryptKey;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Set<String> getPrivilegeSets() {
        return privilegeSets;
    }

    public void setPrivilegeSets(Set<String> privilegeSets) {
        this.privilegeSets = privilegeSets;
    }

	public Date getLastTime() {
		return lastTime;
	}

	public void setLastTime(Date lastTime) {
		this.lastTime = lastTime;
	}

	public Long getLiveTime() {
		if(liveTime == null)
			return DEFAULT_LIVE_TIME;
		return liveTime;
	}

	public void setLiveTime(Long liveTime) {
		this.liveTime = liveTime;
	}
    
	public boolean isExpired(){
		long time = new Date().getTime() - lastTime.getTime();
		//判断是否大于有效时间
		if(time >= getLiveTime() * 60 * 1000){
			return false;
		}
		
		return true;
	}
    
}
