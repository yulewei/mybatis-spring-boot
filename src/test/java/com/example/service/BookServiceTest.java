package com.example.service;

import com.alibaba.fastjson.JSON;
import com.example.common.Page;
import com.example.dto.BookSearch;
import com.example.entity.Book;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BookServiceTest {

    @Autowired
    private BookService service;

    @Test
    public void searchByPage() {
        BookSearch bookSearch = BookSearch.builder().page(1).limit(10).build();
        Page<Book> list = service.searchByPage(bookSearch);
        System.out.println(JSON.toJSONString(list));
    }

    @Test
    public void findByIsbn() {
        List<Book> list = service.findByIsbn("9787115316066");
        System.out.println(list.size());

        Book book = new Book();
        book.setTitle("111");
        book.setAuthor("Will");
        book.setIsbn("12345678");
        book.setPrice("20.0");
        service.getBook2(book);
    }

    @Test
    @Rollback(value = false)
    public void insert() {
        Book book = new Book();
        book.setTitle("111");
        book.setAuthor("Will");
        book.setIsbn("12345678");
        book.setPrice("20.0");
        service.insert(book);
    }

    @Test
    public void readOnly1() {
        Book book = new Book();
        book.setTitle("111");
        book.setAuthor("Will");
        book.setIsbn("12345678");
        book.setPrice("20.0");
        service.getBook1(book);
    }

    @Test
    public void readOnly2() {
        Book book = new Book();
        book.setTitle("111");
        book.setAuthor("Will");
        book.setIsbn("12345678");
        book.setPrice("20.0");
        service.getBook2(book);
    }

    @Test
    @Rollback(value = false)
    public void updateBook() {
        Book book = new Book();
        book.setId(1);
        book.setTitle("222");
        book.setAuthor("Will");
        book.setIsbn("12345678");
        book.setPrice("20.0");
        int count = service.updateBook(book);
        System.out.println(count);
    }

}
