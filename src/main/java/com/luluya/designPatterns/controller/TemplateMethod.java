package com.luluya.designPatterns.controller;

/**
 * 模版方法
 * @author jairy
 * @date 2019/5/18
 */
public class TemplateMethod {
}
//模板方法
abstract class BankTemplateMethod {
    // 1.取号排队
    public void takeNumber() {
        System.out.println("取号排队。。");
    }
    // 2.每个子类不同的业务实现，由各自子类实现.
    abstract void transact();
    // 3.评价
    public void evaluate() {
        System.out.println("反馈评价..");
    }
    public void process(){
        takeNumber();
        transact();
        evaluate();
    }
}
class DrawMoney extends BankTemplateMethod {
    @Override
    void transact() {
        System.out.println("我要取款");
    }
}
class Client {
    public static void main(String[] args) {
        BankTemplateMethod bankTemplate=new DrawMoney();
        bankTemplate.process();
    }
}

