package com.luluya.designPatterns.controller;

/**
 * 外观模式
 * @author jairy
 * @date 2019/5/18
 */
public class FacadePattern {
}
interface EamilSmsService {
    public void sendSms();
}
class EamilSmsServiceImpl implements EamilSmsService{
    @Override
    public void sendSms() {
        System.out.println("发送邮件消息");

    }
}

//微信消息推送
interface WeiXinSmsService {
    public void sendSms();
}
class WeiXinSmsServiceImpl implements WeiXinSmsService {
    @Override
    public void sendSms() {
        System.out.println("发送邮件消息");

    }
}

//阿里短信消息
interface AliSmsService {
    public void sendSms();
}
class AliSmsServiceImpl implements AliSmsService {
    @Override
    public void sendSms() {
        System.out.println("支付宝发送消息...");
    }
}

class Computer {
    AliSmsService aliSmsService;
    EamilSmsService eamilSmsService;
    WeiXinSmsService weiXinSmsService;

    public Computer() {
        aliSmsService = new AliSmsServiceImpl();
        eamilSmsService = new EamilSmsServiceImpl();
        weiXinSmsService = new WeiXinSmsServiceImpl();
    }

    public void sendMsg() {
        aliSmsService.sendSms();
        eamilSmsService.sendSms();
        weiXinSmsService.sendSms();
    }
}

class Client001 {
    public static void main(String[] args) {
        // AliSmsService aliSmsService= new AliSmsServiceImpl();
        // EamilSmsService eamilSmsService= new EamilSmsServiceImpl();
        // WeiXinSmsService weiXinSmsService= new WeiXinSmsServiceImpl();
        // aliSmsService.sendSms();
        // eamilSmsService.sendSms();
        // weiXinSmsService.sendSms();

        new Computer().sendMsg();
    }
}