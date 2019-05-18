package com.luluya.designPatterns.controller;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jairy
 * @date 2019/5/18
 */
/**
 * 观察者的接口，用来存放观察者共有方法
 */
public interface Observer {
    // 观察者方法
    void update(Subjecct subjecct);
}
class ObserverA implements Observer{
    private int myState;
    public int getMyState() {
        return myState;
    }
    @Override
    public void update(Subjecct subjecct) {
    }
}

/**
 * 观察对象的父类
 */
class Subjecct {
    /**
     * 观察者的存储集合
     */
    private List<Observer> list = new ArrayList<>();
    /**
     * 注册观察者方法
     * @param obs
     */
    public void registerObserver(Observer obs) {
        list.add(obs);
    }
    /**
     * 删除观察者方法
     * @param obs
     */
    public void removeObserver(Observer obs) {
        list.remove(obs);
        this.notifyAllObserver();
    }
    /**
     * 通知所有的观察者更新
     */
    public void notifyAllObserver() {
        for (Observer observer : list) {
            observer.update(this);
        }
    }
}

/**
 * 具体观察者对象的实现
 */
class RealObserver extends Subjecct {
    /**
     * 被观察对象的属性
     */
    private int state;
    public int getState(){
        return state;
    }
    public void setState(int state){
        this.state=state;
        //主题对象(目标对象)值发生改变
        this.notifyAllObserver();
    }

}
class Client222 {

    public static void main(String[] args) {
        // 目标对象
        RealObserver subject = new RealObserver();
        // 创建多个观察者
        ObserverA obs1 = new ObserverA();
        ObserverA obs2 = new ObserverA();
        ObserverA obs3 = new ObserverA();
        // 注册到观察队列中
        subject.registerObserver(obs1);
        subject.registerObserver(obs2);
        subject.registerObserver(obs3);
        // 改变State状态
        subject.setState(300);
        System.out.println(obs1.getMyState());
        System.out.println(obs2.getMyState());
        System.out.println(obs3.getMyState());
        // 改变State状态
        subject.setState(400);
        System.out.println(obs1.getMyState());
        System.out.println(obs2.getMyState());
        System.out.println(obs3.getMyState());
    }

}
