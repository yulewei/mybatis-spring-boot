package com.example;

import com.example.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @author yulewei on 2019-09-17
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoApplication.class)
public class CacheTest {
    @Resource
    private UserService userService;

    @Test
    public void name() {
        userService.getUser(1);
    }
}
