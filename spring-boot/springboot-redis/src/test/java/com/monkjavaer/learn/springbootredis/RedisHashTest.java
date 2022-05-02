package com.monkjavaer.learn.springbootpure;

import com.alibaba.fastjson.JSON;
import com.monkjavaer.learn.springbootpure.dto.UserInfo;
import com.monkjavaer.learn.springbootpure.utils.RedisUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.ArrayList;
import java.util.Date;

/**
 * @author monkjavaer
 * @date 2021/1/3
 */
@RunWith(SpringRunner.class)
@SpringBootTest
//由于是Web项目，Junit需要模拟ServletContext，因此我们需要给我们的测试类加上@WebAppConfiguration。
@WebAppConfiguration
public class RedisHashTest {
    @Autowired
    private RedisUtil redisUtil;

    @Test
    public void testHSet1() {
        UserInfo userInfo = new UserInfo();
        userInfo.setId(3L);
        userInfo.setAge(30);
        userInfo.setName("redis");
        userInfo.setCreateTime(new Date());
        userInfo.setRoles(new ArrayList<String>() {{
            add("ADMIN1");
            add("ADMIN2");
        }});
        redisUtil.hset("hset:user", String.valueOf(userInfo.getId()), JSON.toJSONString(userInfo));
    }

    @Test
    public void testHGet() {
        UserInfo userInfo = JSON.parseObject((String) redisUtil.hget("hset:user", "2"), UserInfo.class);
        System.out.println(userInfo.toString());
    }

    @Test
    public void testDel() {
        redisUtil.hdel("hset:user", "3");
    }
}
