package com.luluya.designPatterns.controller;

/**
 * 装饰模式
 * @author jairy
 * @date 2019/5/18
 */
public class Decorate {
}
/**
 * 房屋基础接口
 */
interface House {
    void run();
}
class HouseImpl implements House{
    @Override
    public void run() {
    }
}
/**
 * 房屋装饰类
 */
class HouseDecorate implements House {
    private House house;

    public HouseDecorate(House house){
        this.house=house;
    }

    @Override
    public void run() {
        house.run();
    }

}
class HouseDecorateImpl extends HouseDecorate {
    public HouseDecorateImpl(House house) {
        super(house);
    }

    @Override
    public void run() {
        super.run();
        System.out.println("贴上墙纸..");
    }

}

class ClientTest {
    public static void main(String[] args) {
        HouseImpl houseImpl = new HouseImpl();
        houseImpl.run();
        System.out.println("###新增贴上墙纸..###");
        HouseDecorate houseDecorate = new HouseDecorateImpl(houseImpl);
        houseDecorate.run();
    }
}
