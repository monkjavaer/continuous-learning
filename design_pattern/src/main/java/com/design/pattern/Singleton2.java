package com.design.pattern;

/**
 *
 * 静态内部类
 *
 * @author monkjavaer
 * @date 2021/10/11
 */
public class Singleton2 {

    private static class SingletonHolder {
        private static final Singleton2 INSTANCE = new Singleton2();
    }

    private Singleton2() {
    }

    public static Singleton2 getInstance() {
        return SingletonHolder.INSTANCE;
    }


}
