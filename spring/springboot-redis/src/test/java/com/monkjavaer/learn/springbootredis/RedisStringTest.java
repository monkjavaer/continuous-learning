package com.monkjavaer.learn.springbootredis;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.monkjavaer.learn.springbootredis.dto.UserInfo;
import com.monkjavaer.learn.springbootredis.utils.RedisUtil;
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
public class RedisStringTest {

    @Autowired
    private RedisUtil redisUtil;

    @Test
    public void testSet1() {
        redisUtil.set("learn:string:test1", "first");
    }

    @Test
    public void testSet2() {
        UserInfo userInfo = new UserInfo();
        userInfo.setId(1L);
        userInfo.setAge(20);
        userInfo.setName("redis");
        userInfo.setCreateTime(new Date());
        userInfo.setRoles(new ArrayList<String>() {{
            add("ADMIN1");
            add("ADMIN2");
        }});

//        redisUtil.set("object", userInfo);
    }


    @Test
    public void testSet3() {
        redisUtil.set("learn:string:test3", "string3", 10);
    }

    @Test
    public void testSet4() {
        UserInfo userInfo = new UserInfo();
        userInfo.setId(1L);
        userInfo.setAge(20);
        userInfo.setName("redis");
        userInfo.setCreateTime(new Date());
        userInfo.setRoles(new ArrayList<String>() {{
            add("ADMIN1");
            add("ADMIN2");
        }});

        redisUtil.set("learn:string:test2", JSON.toJSONString(userInfo));
    }


    @Test
    public void testGet1() {
        System.out.println(redisUtil.get("string3"));
    }

    @Test
    public void testGet2() {
        UserInfo user = JSON.parseObject((String) redisUtil.get("object"), new TypeReference<UserInfo>() {
        });
        System.out.println(user.toString());
    }

    @Test
    public void increment() {
        System.out.println(redisUtil.increment("increment", 2));
    }
}
