package com.example.service;

import com.example.entity.User;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by mertcaliskan
 * on 18/08/14.
 */
@Service
public class UserService {

    private Map<Integer, User> users = new HashMap<Integer, User>();

    {
        users.put(1, new User(1, "Kenan"));
        users.put(2, new User(2, "Mert"));
    }

    @Cacheable("users2")
    public User getUser2(int id) {
        System.out.println("User2 with id " + id + " requested.");
        return users.get(id);
    }

    @Cacheable("users")
    public User getUser(int id) {
        System.out.println("User with id " + id + " requested.");
        return users.get(id);
    }

    @CacheEvict(value = "users")
    public void removeUser(int id) {
        users.remove(id);
    }

    @CacheEvict(value = "users", allEntries = true)
    public void removeAll() {
    }
}
