package com.example.demo.java8;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author monkjavaer
 * @date 2021/12/19
 */
public class PredicateTest {

    public static void main(String[] args) {

        //将Predicate作为filter接口，Predicate起到一个判断的作用
        Predicate<Integer> predicate = integer -> integer > 4;

        Stream<Integer> stream = Stream.of(1,3,2,4,5,12,13);
        List<Integer> list = stream.filter(predicate).collect(Collectors.toList());
        list.forEach(System.out::println);

    }
}
