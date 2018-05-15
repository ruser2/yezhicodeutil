package com.yllt.containers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.yllt.containers.entity.FileEntity;
import com.yllt.containers.entity.InvocationContext;
import com.yllt.containers.entity.SessionEntity;
import com.yllt.containers.entity.ThreadLocalManager;

/**
 * @author Administrator
 */
public class ApplicationContext {


    private ApplicationContext() {
    }

    private final Logger logger = LoggerFactory
            .getLogger(ApplicationContext.class);
    public static ApplicationContext CTX = new ApplicationContext();
    private ThreadLocalManager<InvocationContext> threadLocalManager = new ThreadLocalManager<InvocationContext>();

    public ThreadLocalManager<InvocationContext> getThreadLocalManager() {
        return threadLocalManager;
    }

    public InvocationContext getInvocationContext() {
        return getThreadLocalManager().getValue();
    }

    public SessionEntity getSessionEntity() {
        return getThreadLocalManager().getValue().getSessionEntity();
    }
    //放置用户session对象
    public void setSessionEntity(SessionEntity sessionEntity) {
        getThreadLocalManager().getValue().setSessionEntity(sessionEntity);
    }

    public List<FileEntity> getFileList() {
        return getThreadLocalManager().getValue().getFileList();
    }
    //放置文件
    public void setFileList(List<FileEntity> fileList) {
        getThreadLocalManager().getValue().setFileList(fileList);
    }

    public HttpServletRequest getRequest() {
        return getThreadLocalManager().getValue().getRequest();
    }
    //放置request
    public void setRequest(HttpServletRequest request) {
        getThreadLocalManager().getValue().setRequest(request);
    }

    //放置InvocationContext
    public void openThreadLocal(InvocationContext invocationContext) {
        getThreadLocalManager().openThreadLocal(invocationContext);
    }
    //关闭
    void closeThreadLocal() {
        getThreadLocalManager().closeThreadLocal();
    }
}
