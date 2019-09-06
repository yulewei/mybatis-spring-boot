package com.example.job;

import com.alicp.jetcache.anno.config.EnableMethodCache;
import com.example.service.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author yulewei on 16-5-23.
 */
@Component
public class TestJob {

    @Resource
    private BookService bookService;

    private static final Logger logger = LoggerFactory.getLogger(TestJob.class);

//    @Scheduled(fixedRate = 1000)
    public void run() {
        bookService.findByIsbn("9787111255833");
        logger.info("hello你好, {}", 1024);
    }



}
