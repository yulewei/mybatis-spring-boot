package com.example;

import com.example.entity.Book;
import com.example.service.BookService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

    @Autowired
    private BookService bookService;

    @Test
    public void findAll() {
        List<Book> list = bookService.findAll();
        System.out.println(list.size());
    }

    @Test
    public void findByIsbn() {
        List<Book> list = bookService.findByIsbn("9787115316066");
        System.out.println(list.size());

        Book book = new Book();
        book.setTitle("111");
        book.setAuthor("Will");
        book.setIsbn("12345678");
        book.setPrice("20.0");
        bookService.getBook2(book);
    }

    @Test
    public void insert() {
        Book book = new Book();
        book.setTitle("111");
        book.setAuthor("Will");
        book.setIsbn("12345678");
        book.setPrice("20.0");
        bookService.insert(book);
    }


    @Test
    public void readOnly1() {
        Book book = new Book();
        book.setTitle("111");
        book.setAuthor("Will");
        book.setIsbn("12345678");
        book.setPrice("20.0");
        bookService.getBook1(book);
    }

    @Test
    public void readOnly2() {
        Book book = new Book();
        book.setTitle("111");
        book.setAuthor("Will");
        book.setIsbn("12345678");
        book.setPrice("20.0");
        bookService.getBook2(book);
    }


    @Test
    public void updateBook() {
        Book book = new Book();
        book.setId(1);
        book.setTitle("111");
        book.setAuthor("Will");
        book.setIsbn("12345678");
        book.setPrice("20.0");
        int count = bookService.updateBook(book);
        System.out.println(count);
    }

}
