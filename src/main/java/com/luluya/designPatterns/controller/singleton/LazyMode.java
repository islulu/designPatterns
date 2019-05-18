package com.luluya.designPatterns.controller.singleton;

/**
 * 单例模式-饿汉模式
 * @author jairy
 * @date 2019/5/15
 */
public class LazyMode {

    //类初始化时，不会初始化该对象，真正需要使用的时候才会创建该对象。
    private static LazyMode lazyMode;

    private LazyMode(){
        System.out.println("LazyMode初始化");
    }

    //存在线程安全问题 使用synchronized
    private synchronized static LazyMode getInstance(){
        if(lazyMode == null){
            lazyMode = new LazyMode();
        }
        return lazyMode;
    }

    public static void main(String[] args) {
        LazyMode lazyMode1 = LazyMode.getInstance();
        LazyMode lazyMode2 = LazyMode.getInstance();
        System.out.println(lazyMode1 == lazyMode2);
    }

}
