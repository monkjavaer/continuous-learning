package com.example.demo.java8;

import java.util.Arrays;
import java.util.List;

/**
 * @author monkjavaer
 * @date 2021/12/18
 */
public class LambdaTest {

    public static void main(String[] args) {

        List<String> list = Arrays.asList("a", "d", "b");


        Arrays.asList("a", "b", "d").forEach(i -> {
            if ("a".equals(i)) {
                System.out.println(i);
            }
        });
        Arrays.asList("a", "b", "d").forEach(e -> System.out.println(e));
        Arrays.asList("a", "b", "d").forEach(System.out::println);


        list.sort((e1, e2) -> e1.compareTo(e2));

        list.sort((e1, e2) -> {
            int i = e1.compareTo(e2);
            return i;
        });

        list.sort(String::compareTo);
        System.out.println("compareTo:" + list);

    }
}
