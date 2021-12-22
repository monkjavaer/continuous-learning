package com.example.demo.java8;

import java.util.Optional;

/**
 * @author monkjavaer
 * @date 2021/12/21
 */
public class OptionalTest {


    public static void main(String[] args) {

        People people1 = new People();

        People people2 = null;

        //创建Optional实例
        //Optional of 参数方法必须非空
        Optional<People> optional1 = Optional.of(people1);
//        Optional<People> optional1 = Optional.of(people2);


        people2 = new People();
        Name name = new Name("firstName",null);
        people2.setName(name);
        Optional<People> optional2 = Optional.ofNullable(people2);

        //获取Optional对象值 ,Optional get() 值为空时会抛出空指针，
//        System.out.println(optional2.get());


        String name1 = Optional.ofNullable(people2.getName().getLastName()).orElse(createLastName());
        String name2 = Optional.ofNullable(people2.getName().getLastName()).orElseGet(() -> createLastName());

        String namenull = Optional.ofNullable(people2)
                .map(People::getName)
                .map(Name::getLastName)
                .orElseGet(OptionalTest::createLastName);

        System.out.println(namenull);
        String name3 = Optional.ofNullable(people2.getName().getFirstName()).orElse(createFirstName());
        String name4 = Optional.ofNullable(people2.getName().getFirstName()).orElseGet(() -> createFirstName());
    }



    public static String createLastName() {
        System.out.println("createLastName");
        return "createLastName";
    }

    public static String createFirstName() {
        System.out.println("createFirstName");
        return "createFirstName";
    }

    static class People {
        private Name name;

        public Name getName() {
            return name;
        }

        public void setName(Name name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "People{" +
                    "name=" + name +
                    '}';
        }
    }
    static class Name {
        private String firstName;
        private String lastName;

        public Name(String firstName, String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
        }

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        @Override
        public String toString() {
            return "Name{" +
                    "firstName='" + firstName + '\'' +
                    ", lastName='" + lastName + '\'' +
                    '}';
        }
    }

}
