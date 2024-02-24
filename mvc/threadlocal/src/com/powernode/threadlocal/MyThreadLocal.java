package com.powernode.threadlocal;

import java.util.HashMap;
import java.util.Map;

/*
* 自定义一个 ThreadLocal 类
* */
public class MyThreadLocal<T> {


    /*
    * 所有需要和当前线程绑定的数据要放到这个容器当中
    * */
    private Map<Thread, T> map = new HashMap<>();

    /*
    * 向 ThreadLocal 中绑定数据
    * */
    public void set(T obj) {
        map.put(Thread.currentThread(), obj);
    }

    /*
    * 从 ThreadLocal 中获取数据
    * @return
    * */
    public T get() {
        return map.get(Thread.currentThread());
    }

    /*
    * 移除 ThreadLocal 当中的数据
    * */
    public void remove() {
        map.remove(Thread.currentThread());
    }
}
