package com.yllt.containers;

import com.yllt.containers.entity.InvocationContext;
import com.yllt.containers.entity.ThreadLocalManager;

/**
 * Created by Administrator on 2015/12/21.
 */
public class ThreadLocalContainer {
    private final ThreadLocalManager<InvocationContext> manager=new ThreadLocalManager<InvocationContext>();
    public void openThreadLocal(InvocationContext invocationContext){
        manager.openThreadLocal(invocationContext);
    }

    public InvocationContext getValue(){
        return manager.getValue();
    }

    public void closeThreadLocal(){
        manager.closeThreadLocal();
    }
}
