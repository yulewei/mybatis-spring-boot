package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Book;
import com.example.service.BookService;

@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/")
    public List<Book> home() {
        return bookService.findAll();
    }

    @GetMapping("/books")
    public List<Book> books() {
        return home();
    }

    @GetMapping("/books/{isbn}")
    public List<Book> bookByIsbn(@PathVariable("isbn") String isbn) {
        return bookService.findByIsbn(isbn);
    }
}
