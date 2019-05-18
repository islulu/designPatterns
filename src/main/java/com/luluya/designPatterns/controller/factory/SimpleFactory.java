package com.luluya.designPatterns.controller.factory;

import org.springframework.util.StringUtils;

/**
 * @author jairy
 * @date 2019/5/16
 */
public class SimpleFactory {
}

interface Car {
    public void run();
}
class AoDi implements Car {
    @Override
    public void run() {
        System.out.println("我是奥迪汽车..");
    }
}
class JiLi implements Car {
    @Override
    public void run() {
        System.out.println("我是吉利汽车...");
    }
}
class CarFactory{
    public static Car createCar(String name) {
        if (StringUtils.isEmpty(name)) {
            return null;
        }
        Car car = null;
        switch (name){
            case "奥迪":
                car = new AoDi();
                break;
            case "吉利":
                car = new JiLi();
                break;
            default:
                break;
        }
        return car;
    }
}
class Client{
    public static void main(String[] args) {
        Car aoDi = CarFactory.createCar("奥迪");
        Car jili = CarFactory.createCar("吉利");
        aoDi.run();
        jili.run();
    }
}