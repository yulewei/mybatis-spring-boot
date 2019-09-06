package com.example.controller;

import com.alicp.jetcache.anno.Cached;
import com.example.entity.Book;
import com.example.job.TestJob;
import com.example.service.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
public class BookController {
    private static final Logger logger = LoggerFactory.getLogger(TestJob.class);

    @Autowired
    private HttpServletRequest request;
    @Autowired
    private HttpSession session;
    @Autowired
    private BookService bookService;

    @RequestMapping("set")
    public Book set(HttpServletRequest req) {
        Book book = Book.builder().id(123).isbn("123456").build();
        req.getSession().setAttribute("book", book);
        return book;
    }

    @RequestMapping("query")
    public Book query(HttpServletRequest req) {
        Book book = (Book) req.getSession().getAttribute("book");
        return book;
    }

    @GetMapping("/")
    public List<Book> home() {
        System.out.println(session.getId());
        return bookService.findAll();
    }

    /**
     * http://localhost:8080/book
     */
    @GetMapping("/book")
    public List<Book> book() {
        return home();
    }

    @GetMapping("/book/{isbn}")
    public List<Book> bookByIsbn(@PathVariable("isbn") String isbn) {
        return bookService.findByIsbn(isbn);
    }

    /**
     * curl -XPOST -H 'Content-Type: application/json' http://localhost:8080/book3?isbn=123
     */
    @PostMapping("/book3")
    @Cached(name = "user:book:", key = "#isbn", expire = 3600)
    public List<Book> bookByIsbn3(String isbn) {
        logger.info("bookByIsbn3");
        return bookService.findByIsbn(isbn);
    }

    /**
     * curl -XPOST -H 'Content-Type: application/json' -d '{"isbn": 123}' http://localhost:8080/book2
     */
    @PostMapping(value = "/book2")
    public Book bookByIsbn2(@RequestBody Book book) {
        return book;
    }

    /**
     * curl -XPOST -d 'isbn=123' http://localhost:8080/book2
     */
    @PostMapping(value = "/book2", consumes = {"application/x-www-form-urlencoded"})
    public Book bookByIsbn3(Book book) {
        return book;
    }

    @PostMapping("/book/insert")
    public Integer insert(@RequestBody Book book) {
        return bookService.insert(book);
    }

}
