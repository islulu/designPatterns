package com.luluya.designPatterns.controller.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * JDK动态代理
 * @author jairy
 * @date 2019/5/17
 */

/**
 * 每次生成动态代理类对象时,实现了InvocationHandler接口的调用处理器对象
 */
public class InvocationHandlerImpl implements InvocationHandler {

    /**
     * 这其实业务实现类对象，用来调用具体的业务方法
     */
    private Object target;

    /**
     * 通过构造函数传入目标对象
     * @param target
     */
    public InvocationHandlerImpl(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result = null;
        System.out.println("调用开始处理");
        result = method.invoke(target, args);
        System.out.println("调用结束处理");
        return result;
    }

    public static void main(String[] args) throws NoSuchMethodException, SecurityException, InstantiationException,
            IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        // 被代理对象
        IUserDao userDao = new UserDao();
        //获取类加载器
        ClassLoader loader = userDao.getClass().getClassLoader();
        //获取接口
        Class<?>[] interfaces = userDao.getClass().getInterfaces();
        InvocationHandlerImpl invocationHandlerImpl = new InvocationHandlerImpl(userDao);
        // 主要装载器、一组接口及调用处理动态代理实例
        IUserDao newProxyInstance = (IUserDao) Proxy.newProxyInstance(loader, interfaces, invocationHandlerImpl);
        newProxyInstance.save();
    }

}