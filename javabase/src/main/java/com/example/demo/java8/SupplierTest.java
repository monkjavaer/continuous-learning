package com.example.demo.java8;

import java.util.Optional;
import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Stream;

/**
 * @author monkjavaer
 * @date 2021/12/18
 */
public class SupplierTest {

    public static void main(String[] args) {

        People people1 = factory(People::new);

        People people2 = factory(() -> new People("Lee"));

        System.out.println(people1.toString());
        System.out.println(people2.toString());

        System.out.println("========================================================");


        Stream<Integer> stream = Stream.of(1, 2, 3, 4);
        //返回一个optional对象
        Optional<Integer> first = stream.filter(i -> i > 4)
                .findFirst();

        //optional对象有需要Supplier接口的方法
        //orElse，如果first中存在数，就返回这个数，如果不存在，就放回传入的数
        System.out.println(first.orElse(1));
        System.out.println(first.orElse(7));

        System.out.println("********************");

        Supplier<Integer> supplier = new Supplier<Integer>() {
            @Override
            public Integer get() {
                //返回一个随机值
                return new Random().nextInt();
            }
        };

        //orElseGet，如果first中存在数，就返回这个数，如果不存在，就返回supplier返回的值
        System.out.println(first.orElseGet(supplier));

    }

    public static People factory(Supplier<People> supplier) {
        People people = supplier.get();
        if (people.getName() == null || "".equals(people.getName())) {
            people.setName("Supplier");
        }
        people.setAge(100);
        return people;
    }

    static class People {
        private String name;
        private String sex;
        private Integer age;

        public People(String name) {
            this.name = name;
        }

        public People() {

        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getSex() {
            return sex;
        }

        public void setSex(String sex) {
            this.sex = sex;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }

        @Override
        public String toString() {
            return "People{" +
                    "name='" + name + '\'' +
                    ", sex='" + sex + '\'' +
                    ", age=" + age +
                    '}';
        }
    }
}
