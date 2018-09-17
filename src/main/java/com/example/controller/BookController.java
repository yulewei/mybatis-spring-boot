package com.example.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.entity.Book;
import com.example.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/")
    public List<Book> home() {
        return bookService.findAll();
    }

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
    public List<Book> bookByIsbn3(String isbn) {
        return bookService.findByIsbn(isbn);
    }

    /**
     * curl -XPOST -H 'Content-Type: application/json' -d '{"isbn": 123}' http://localhost:8080/book2
     */
    @PostMapping("/book2")
    public List<Book> bookByIsbn2(@RequestBody JSONObject isbn) {
        return bookService.findByIsbn(isbn.getString("isbn"));
    }

    @PostMapping("/book/insert")
    public Integer insert(@RequestBody Book Book) {
        return bookService.insert(Book);
    }

}
