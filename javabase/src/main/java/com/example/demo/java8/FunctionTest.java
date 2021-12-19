package com.example.demo.java8;

import java.util.function.Function;
import java.util.stream.Stream;

/**
 * @author monkjavaer
 * @date 2021/12/19
 */
public class FunctionTest {

    public static void main(String[] args) {
        //使用map方法，泛型的第一个参数是转换前的类型，第二个是转化后的类型
        Function<String, Integer> function = s -> {
            System.out.println("获取字符串" + s + "的长度");
            return s.length();
        };

        Stream<String> stream = Stream.of("sada", "dfg", "12");
        Stream<Integer> stream1 = stream.map(function);
        stream1.forEach(System.out::println);
    }
}
