package com.zhang.redis;

import com.zhang.RedisAppilcation;
import com.zhang.config.RedisUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = RedisAppilcation.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class RedisTest {

    @Autowired
    RedisUtils redisUtils;

    @Test
    public void redis(){
        boolean set = redisUtils.set("ss11", "sss");
       // System.out.println(set);
    }
}
