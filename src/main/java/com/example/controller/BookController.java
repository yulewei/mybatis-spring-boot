package com.example.controller;

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

    @PostMapping("/book/insert")
    public Integer insert(@RequestBody Book Book) {
        return bookService.insert(Book);
    }

}
