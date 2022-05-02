package com.monkjavaer.learn.springbootpure;

import com.monkjavaer.learn.springbootpure.utils.RedisUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * @author monkjavaer
 * @date 2021/1/3
 */
@RunWith(SpringRunner.class)
@SpringBootTest
//由于是Web项目，Junit需要模拟ServletContext，因此我们需要给我们的测试类加上@WebAppConfiguration。
@WebAppConfiguration
public class HyperLogLogTest {

    @Autowired
    RedisUtil redisUtil;

    @Test
    public void pfadd() {
        redisUtil.pfadd("page1", "user1");
        redisUtil.pfadd("page1", "user2");
        redisUtil.pfadd("page1", "user3");
    }

    @Test
    public void pfadd2() {
        for (int i = 0; i < 100; i++) {
            redisUtil.pfadd("page3", "auser" + i);
        }
    }

    @Test
    public void pfCount() {
        System.out.println(redisUtil.pfCount("page3"));
    }

    @Test
    public void pfMerge() {
        System.out.println(redisUtil.pfMerge("page","page1","page2","page3"));
    }
}
