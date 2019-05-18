package com.luluya.designPatterns.controller.singleton;

/**
 * 单例模式-双重检测锁
 * @author jairy
 * @date 2019/5/15
 */
public class DoubleDetectionLockMode {

    private DoubleDetectionLockMode doubleDetectionLockMode;

    private DoubleDetectionLockMode() {

    }

    public DoubleDetectionLockMode getInstance() {
        if (doubleDetectionLockMode == null) {
            synchronized (this) {
                if (doubleDetectionLockMode == null) {
                    doubleDetectionLockMode = new DoubleDetectionLockMode();
                }
            }
        }
        return doubleDetectionLockMode;
    }

}