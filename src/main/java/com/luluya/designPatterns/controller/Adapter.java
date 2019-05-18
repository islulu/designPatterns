package com.luluya.designPatterns.controller;

/**
 * 适配器模式
 * @author jairy
 * @date 2019/5/18
 */
public class Adapter {
}

//日本110V 电源接口
interface JP110VInterface {
    public void connect();
}
class JP110VInterfaceImpl implements JP110VInterface {
    @Override
    public void connect() {
        System.out.println("日本110V,接通电源,开始工作..");
    }
}

interface CN220VInterface {
    public void connect();
}
class CN220VInterfaceImpl implements CN220VInterface {
    @Override
    public void connect() {
        System.out.println("中国220V,接通电源,开始工作");
    }
}
//适配器
class PowerAdaptor implements JP110VInterface {
    private CN220VInterface cn220VInterface;

    public PowerAdaptor(CN220VInterface cn220VInterface) {
        this.cn220VInterface = cn220VInterface;
    }

    @Override
    public void connect() {
        cn220VInterface.connect();
    }

}

class ElectricCooker {

    private JP110VInterface jp110VInterface;//日本电饭煲
    ElectricCooker(JP110VInterface jp110VInterface){
        this.jp110VInterface=jp110VInterface;
    }

    public void cook(){
        jp110VInterface.connect();
        System.out.println("开始做饭了..");
    }

}
class AdaptorTest {

    public static void main(String[] args) {
        CN220VInterface cn220VInterface = new CN220VInterfaceImpl();
        PowerAdaptor powerAdaptor = new PowerAdaptor(cn220VInterface);
        // 电饭煲
        ElectricCooker cooker = new ElectricCooker(powerAdaptor);
        cooker.cook();//使用了适配器,在220V的环境可以工作了。
    }

}