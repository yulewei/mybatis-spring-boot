//package com.example.controller;
//
//import com.alicp.jetcache.Cache;
//import com.alicp.jetcache.anno.Cached;
//import com.alicp.jetcache.anno.CreateCache;
//import com.example.common.cache.SerialPolicyEx;
//import com.example.job.TestJob;
//import com.example.service.BookService;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import javax.annotation.Resource;
//import java.awt.print.Book;
//import java.util.List;
//
///**
// * @author yulewei on 2019-09-03
// */
//@RestController
//@RequestMapping("cache")
//public class CacheController {
//    private static final Logger logger = LoggerFactory.getLogger(TestJob.class);
//    @Resource
//    private BookService bookService;
//    @CreateCache(serialPolicy = SerialPolicyEx.FASTJSON)
//    private Cache<String, String> cache;
//
//    /**
//     * curl -XPOST http://localhost:8080/cache/book?isbn=9787111255833
//     */
//    @PostMapping("book")
//    @Cached(name = "user:book:", key = "#isbn", expire = 3600)
//    public List<Book> bookCache(String isbn) {
//        logger.info("bookCache");
//        return bookService.findByIsbn(isbn);
//    }
//
//    /**
//     * curl -XPOST http://localhost:8080/cache/cache
//     */
//    @PostMapping("cache")
//    public Object cache() {
//        cache.put("hello", "world");
//        Object obj = cache.get("hello");
//        logger.info("cache {}", obj);
//        return obj;
//    }
//}
