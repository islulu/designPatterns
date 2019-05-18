package com.luluya.designPatterns.controller.singleton;

/**
 * 单例模式-枚举
 * @author jairy
 * @date 2019/5/15
 */
public class EnumMode {

    private static enum SingletonEnumMode {
        INSTANCE;

        // 枚举元素为单例
        private EnumMode enumMode;

        SingletonEnumMode() {
            System.out.println("SingletonEnumMode初始化");
            enumMode = new EnumMode();
        }

        public EnumMode getInstance() {
            return enumMode;
        }
    }

    public static EnumMode getInstance() {
        return SingletonEnumMode.INSTANCE.getInstance();
    }


    public static void main(String[] args) {
        EnumMode enumMode1 = EnumMode.getInstance();
        EnumMode enumMode2 = EnumMode.getInstance();
        System.out.println(enumMode1 == enumMode2);
    }
}
