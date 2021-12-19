package com.example.demo.java8;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/**
 * @author monkjavaer
 * @date 2021/12/18
 */
public class ConsumerTest {

    public static void main(String[] args) {
        Consumer<Integer> consumer = i -> {
            System.out.println("Consumer 接收 参数 i 开始处理");
            int step = 1;
            System.out.printf("Consumer 输入%d, 输出%d%n", i, i + step);
        };

        List<Integer> list = Arrays.asList(4, 2, 6);
        list.forEach(consumer);
    }
}
