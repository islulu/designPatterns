package com.luluya.designPatterns.controller.reflection;

/**
 * @author jairy
 * @date 2019/5/15
 */
public class ReflectionEntity extends Object{

    private String username;

    public ReflectionEntity(){
        System.out.println("对象初始化");
//        throw new RuntimeException();//构造函数中，如果发生异常，对象创建不会成功
    }

    public ReflectionEntity(String username){
        System.out.println("username: "+username);
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
