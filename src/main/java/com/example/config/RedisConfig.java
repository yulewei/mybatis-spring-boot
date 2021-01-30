package com.example.config;

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.JedisPool;

/**
 * @author yulewei on 2021/1/20
 */
@Configuration
public class RedisConfig {

    @Bean
    public JedisPool adminJedisPool() {
        return new JedisPool(genericObjectPoolConfig(), "localhost", 6379, 2000);
    }

    @Bean
    public GenericObjectPoolConfig genericObjectPoolConfig() {
        GenericObjectPoolConfig config = new GenericObjectPoolConfig();
        config.setTestOnBorrow(true);
        return config;
    }
}
