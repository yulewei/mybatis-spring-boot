//package com.example.config;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.springframework.context.annotation.Bean;
//import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
//import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
//import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
//import org.springframework.data.redis.serializer.RedisSerializer;
//import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
//import org.springframework.session.web.http.CookieSerializer;
//import org.springframework.session.web.http.DefaultCookieSerializer;
//
///**
// * @author yulewei on 2018/9/27
// */
//@EnableRedisHttpSession(redisNamespace = "admin:session")
//public class HttpSessionConfig {
//
//    @Bean
//    public JedisConnectionFactory connectionFactory() {
//        RedisStandaloneConfiguration configuration = new RedisStandaloneConfiguration("127.0.0.1", 6379);
//        return new JedisConnectionFactory(configuration);
//    }
//
//    @Bean
//    public RedisSerializer<Object> springSessionDefaultRedisSerializer() {
//        return new GenericJackson2JsonRedisSerializer(new ObjectMapper());
//    }
//
//    @Bean
//    public CookieSerializer cookieSerializer() {
//        DefaultCookieSerializer serializer = new DefaultCookieSerializer();
//        serializer.setCookieName("JSESSIONID");
//        serializer.setUseBase64Encoding(false);
//        return serializer;
//    }
//}
