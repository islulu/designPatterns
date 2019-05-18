package com.luluya.designPatterns.controller.factory;

/**
 * @author jairy
 * @date 2019/5/17
 */
public class AbstractFactoryMethod {
}
//发动机
interface Engine {
    void run();
    void start();
}
class EngineA implements Engine {
    @Override
    public void run() {
        System.out.println("转的快!");
    }
    @Override
    public void start() {
        System.out.println("启动快,自动档");
    }
}
class EngineB implements Engine {
    @Override
    public void run() {
        System.out.println("转的慢!");
    }
    @Override
    public void start() {
        System.out.println("启动快,手动档");
    }
}
//座椅
interface Chair {
    void run();
}
class ChairA implements Chair{
    @Override
    public void run() {
        System.out.println("可以自动加热!");
    }
}
class ChairB implements Chair{
    @Override
    public void run() {
        System.out.println("不能加热!");
    }

}

interface CarFactory3 {
    // 创建发动机
    Engine createEngine();
    // 创建座椅
    Chair createChair();
}
class JiLiFactory3 implements CarFactory3  {
    @Override
    public Engine createEngine() {
        return new EngineA();
    }
    @Override
    public Chair createChair() {
        return new ChairA();
    }
}

class Client03 {

    public static void main(String[] args) {
        CarFactory3 carFactory=new JiLiFactory3();
        Engine engine=carFactory.createEngine();
        engine.run();
        engine.start();
    }

}