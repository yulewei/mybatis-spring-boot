package com.example;

import com.alicp.jetcache.Cache;
import com.alicp.jetcache.anno.CreateCache;
import com.example.job.TestJob;
import com.example.service.BookService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @author yulewei on 2019-09-03
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CacheTest {
    private static final Logger logger = LoggerFactory.getLogger(TestJob.class);

    @CreateCache(serialPolicy = "json")
    private Cache<String, String> cache;
    @Resource
    private BookService bookService;

    @org.junit.Test
    public void testHello() {
        cache.put("hello", "world");
        Object obj = cache.get("hello");
        System.out.println(obj);
    }

    @Test
    public void name() throws InterruptedException {
        logger.info("start");
        bookService.asyncRun();
        logger.info("end");

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
