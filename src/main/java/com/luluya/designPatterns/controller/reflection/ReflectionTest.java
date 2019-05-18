package com.luluya.designPatterns.controller.reflection;

import java.lang.reflect.*;

/**
 * @author jairy
 * @date 2019/5/15
 */
public class ReflectionTest {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        // 1.初始化的操作 无参构造函数
        ReflectionEntity reflectionEntity = new ReflectionEntity();
        reflectionEntity.setUsername("初始化的操作");
        System.out.println(reflectionEntity.getUsername());

        System.out.println("------反射机制获取类的方法------");
        // 2.使用Java反射机制创建对象 类的完整路径
        // 也会走 无参构造函数
        Class<?> forName = Class.forName("com.luluya.designPatterns.controller.reflection.ReflectionEntity");
        // 3.使用反射机制创建对象
        ReflectionEntity fornameNewInstance = (ReflectionEntity) forName.newInstance();
        fornameNewInstance.setUsername("使用反射机制创建对象");
        System.out.println(fornameNewInstance.getUsername());
        // 4.反射应用场景 (1)jdbc链接、springIOC底层使用反射机制+DOM4J (2)框架mybatis使用到反射机制

        System.out.println("--------反射创建对象的方式----------");
        // 5.实例化有参构造函数
        Constructor<?> constructor = forName.getConstructor(String.class);
        ReflectionEntity constructorParametersNewInstance = (ReflectionEntity) constructor.newInstance("有参构造函数");
        System.out.println(constructorParametersNewInstance.getUsername());

        System.out.println("------反射创建api------");
        // 6.使用反射机制 获取类的信息
        Method[] methods = forName.getDeclaredMethods();
        for (Method method : methods) {
            System.out.println(method.getName());
        }
        // 7.使用反射机制 获取类的属性
        Field[] fields = forName.getDeclaredFields();
        for (Field field : fields) {
            System.out.println(field.getName());
        }

        System.out.println("------------------");
        // 8.使用反射机制创建对象(破坏单例的私有构造函数保护
        Constructor c0 = forName.getDeclaredConstructor();
        c0.setAccessible(true);
        ReflectionEntity constructorNewInstance = (ReflectionEntity) c0.newInstance();
        constructorNewInstance.setUsername("破坏单例的私有构造函数保护");
        System.out.println(constructorNewInstance.getUsername());

        // 9.如何防止被反射 构造方法设置为 单例私有


    }
}
