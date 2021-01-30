package com.example.job;

import com.example.service.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author yulewei on 16-5-23.
 */
@Component
public class TestJob {
    private AtomicInteger index = new AtomicInteger();

    @Resource
    private BookService bookService;

    private static final Logger logger = LoggerFactory.getLogger(TestJob.class);

    @Scheduled(fixedRate = 1000)
    public void run() throws InterruptedException {
        index.incrementAndGet();
        logger.info("start, {}", index);
//        bookService.findByIsbn("9787111255833");
//        logger.info("hello你好, {}", index);
        TimeUnit.SECONDS.sleep(2);
        logger.info("end, {}", index);
    }

}
