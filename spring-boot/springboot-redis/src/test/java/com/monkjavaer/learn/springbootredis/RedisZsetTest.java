package com.monkjavaer.learn.springbootredis;

import com.monkjavaer.learn.springbootredis.utils.RedisUtil;
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
public class RedisZsetTest {

    @Autowired
    private RedisUtil redisUtil;

    @Test
    public void testZAdd() {
        redisUtil.zadd("zset:learn:hot", "Java",9);
        redisUtil.zadd("zset:learn:hot", "python",5);
        redisUtil.zadd("zset:learn:hot", "GO",6);
        redisUtil.zadd("zset:learn:hot", "C++",2);
    }

    @Test
    public void testRank() {
        System.out.println(redisUtil.zrank("zset:learn:hot", "C++"));
    }

    @Test
    public void zreverseRank() {
        System.out.println(redisUtil.zreverseRank("zset:learn:hot", "C++"));
    }

    @Test
    public void zscore() {
        System.out.println(redisUtil.zscore("zset:learn:hot", "C++"));
    }

    @Test
    public void zrange() {
        System.out.println(redisUtil.zrange("zset:learn:hot", 0, -1));
    }

    @Test
    public void zrevRange() {
        System.out.println(redisUtil.zrevRange("zset:learn:hot", 0, -1));
    }

    @Test
    public void rangeByScore() {
        System.out.println(redisUtil.rangeByScore("zset:learn:hot", 0, 6));
    }

    @Test
    public void zCard() {
        System.out.println(redisUtil.zCard("zset:learn:hot"));
    }
}
