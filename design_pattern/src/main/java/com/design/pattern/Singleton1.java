package com.design.pattern;

/**
 *
 * 双检锁/双重校验锁（DCL，即 double-checked locking）
 *
 * @author monkjavaer
 * @date 2021/10/11
 */
public class Singleton1 {
    private volatile static Singleton1 singleton;

    private Singleton1() {
    }

    public static Singleton1 getSingleton() {
        if (singleton == null) {
            synchronized (Singleton1.class) {
                if (singleton == null) {
                    singleton = new Singleton1();
                }
            }
        }
        return singleton;
    }
}
