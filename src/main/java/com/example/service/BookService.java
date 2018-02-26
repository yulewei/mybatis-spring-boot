package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Book;
import com.example.entity.criteria.BookExample;
import com.example.mapper.IBookDAO;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author yulewei on 2017/11/22
 */
@Service
public class BookService {

    @Autowired
    private IBookDAO bookDAO;

    public List<Book> findAll() {
        BookExample example = new BookExample();
        return bookDAO.selectByExample(example);
    }

    public List<Book> findByIsbn(String isbn) {
        BookExample example = new BookExample();
        example.createCriteria().andIsbnEqualTo(isbn);
        return bookDAO.selectByExample(example);
    }

    @Transactional
    public Integer insert(Book book) {
        bookDAO.insertSelective(book);
        return book.getId();
    }

}
