package com.test.xml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author monkjavaer
 * @date 2021/10/10
 */
public class ApplicationContextTest {

    public static void main(String[] args) {
        //启动 ApplicationContext
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring.xml");

        System.out.println("context 启动成功");

        // 从 context 中取出 Bean，而不是用 new  这种方式
        HelloService helloService = context.getBean(HelloService.class);
        // 这句将输出: hello world
        System.out.println(helloService.hello());

    }
}
