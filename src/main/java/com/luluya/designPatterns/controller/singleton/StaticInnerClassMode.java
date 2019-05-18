package com.luluya.designPatterns.controller.singleton;

/**
 * 单例模式-静态内部类
 * @author jairy
 * @date 2019/5/15
 */
public class StaticInnerClassMode {

    private StaticInnerClassMode(){
        System.out.println("StaticInnerClassMode初始化");
    }

    private static class StaticInnerClassModeInstance{
        private static final StaticInnerClassMode staticInnerClassMode = new StaticInnerClassMode();
    }

    private static StaticInnerClassMode getInstance(){
        System.out.println("getInstance");
        return StaticInnerClassModeInstance.staticInnerClassMode;
    }

    public static void main(String[] args) {
        StaticInnerClassMode staticInnerClassMode1 = StaticInnerClassMode.getInstance();
        StaticInnerClassMode staticInnerClassMode2 = StaticInnerClassMode.getInstance();
        System.out.println(staticInnerClassMode1 == staticInnerClassMode2);
    }

}
