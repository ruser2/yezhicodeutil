package com.yllt.containers.entity;

/**
 * Created by Administrator on 2015/12/21.
 */
public class ThreadLocalManager<T> {
    private final ThreadLocal<T> threadLocal = new ThreadLocal<T>();

    public void openThreadLocal(T t) {
        threadLocal.set(t);
    }

    public T getValue() {
        return threadLocal.get();
    }

    public void closeThreadLocal() {
        threadLocal.remove();
    }
}