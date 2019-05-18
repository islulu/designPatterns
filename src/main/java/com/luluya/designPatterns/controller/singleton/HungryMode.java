package com.luluya.designPatterns.controller.singleton;

/**
 * 单例模式-饿汉模式
 * @author jairy
 * @date 2019/5/15
 */
public class HungryMode {

    private static HungryMode hungryMode = new HungryMode();

    private HungryMode(){
        System.out.println("HungryMode初始化");
    }

    private static HungryMode getInstance(){
        return hungryMode;
    }

    public static void main(String[] args) {
        HungryMode hungryMode1 = HungryMode.getInstance();
        HungryMode hungryMode2 = HungryMode.getInstance();
        System.out.println(hungryMode1 == hungryMode2);
    }

}
