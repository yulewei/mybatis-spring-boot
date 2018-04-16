package com.example.service;

import com.example.entity.Book;
import com.example.entity.criteria.BookExample;
import com.example.mapper.BookMapper;
import org.apache.commons.lang3.time.StopWatch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author yulewei on 2017/11/22
 */
@Service
public class BookService {

    @Autowired
    private BookMapper bookMapper;

    public List<Book> findAll() {
        BookExample example = new BookExample();
        return bookMapper.selectByExample(example);
    }

    @Transactional(readOnly = true)
    public List<Book> findByIsbn(String isbn) {
        BookExample example = new BookExample();
        example.createCriteria().andIsbnEqualTo(isbn);
        return bookMapper.selectByExample(example);
    }

    @Transactional(readOnly = true)
    public Integer insert(Book book) {
        bookMapper.insertSelective(book);
        return book.getId();
    }

    public Integer getBook1(Book book) {
        bookMapper.insertSelective(book);
        return book.getId();
    }

    @Transactional
    public Integer getBook2(Book book) {
        bookMapper.insertSelective(book);
        return book.getId();
    }

    @Transactional
    public Integer updateBook(Book book) {
        bookMapper.updateByPrimaryKeySelective(book);
        return book.getId();
    }
}
