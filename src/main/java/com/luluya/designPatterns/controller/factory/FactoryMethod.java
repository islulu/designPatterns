package com.luluya.designPatterns.controller.factory;

import org.springframework.util.StringUtils;

/**
 * @author jairy
 * @date 2019/5/16
 */
public class FactoryMethod {
}

interface Car1 {
    public void run();
}
class AoDi1 implements Car1 {
    @Override
    public void run() {
        System.out.println("我是奥迪汽车..");
    }
}
class JiLi1 implements Car1 {
    @Override
    public void run() {
        System.out.println("我是吉利汽车...");
    }
}

interface CarFactory1{
    public static Car1 createCar(String name) {
        if (StringUtils.isEmpty(name)) {
            return null;
        }
        Car1 car = null;
        switch (name){
            case "奥迪":
                car = new AoDi1();
                break;
            case "吉利":
                car = new JiLi1();
                break;
            default:
                break;
        }
        return car;
    }
}
class AoDiFactory1 implements CarFactory1 {
    public Car1 createCar() {
        return new AoDi1();
    }
}
class JiLiFactory1 implements CarFactory1 {
    public Car1 createCar() {
        return new JiLi1();
    }
}

class Client1{
    public static void main(String[] args) {
        Car1 aodi = new AoDiFactory1().createCar();
        Car1 jili = new JiLiFactory1().createCar();
        aodi.run();
        jili.run();
    }
}