package com.example.service;

import com.example.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @author yulewei on 2018/11/7
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {

    @Resource
    private UserService userService;

    @Test
    public void getUser() {
        User user = userService.getUser(1);
        System.out.println(user);
    }

    @Test
    public void getUser2() {
        User user = userService.getUser2(1);
        userService.removeUser(1);
        System.out.println(user);
    }

}
