package com.luluya.designPatterns.controller.singleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * 单例防止反射漏洞攻击
 * @author jairy
 * @date 2019/5/15
 */
public class Demo {

    /**
     * 在构造函数中，只能允许初始化化一次即可
     */
    private static boolean flag = false;

    private Demo() {
        if (flag == false) {
            flag = !flag;
        } else {
            System.out.println("该对象是单例的，不能够重复创建！");
            throw new RuntimeException("该对象是单例的，不能够重复创建！");
        }
    }

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<?> forName = Class.forName("com.luluya.designPatterns.controller.singleton.Demo");
        Constructor<?> declaredConstructor = forName.getDeclaredConstructor(null);
        declaredConstructor.setAccessible(true);
        Object s1 = declaredConstructor.newInstance();
    }

}
