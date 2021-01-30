package com.example.service;

import com.example.common.Page;
import com.example.common.PageUtils;
import com.example.dto.BookSearch;
import com.example.entity.Book;
import com.example.entity.criteria.BookExample;
import com.example.mapper.BookMapper;
import com.github.pagehelper.PageHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author yulewei on 2017/11/22
 */
@Service("bookService")
public class BookService {
    private static final Logger logger = LoggerFactory.getLogger(BookService.class);

    @Lazy
    @Resource
    private BookService bookService;
    @Resource
    private BookMapper bookMapper;

    public Page<Book> searchByPage(BookSearch bookSearch) {
        PageHelper.startPage(bookSearch.getPage(), bookSearch.getLimit());
        BookExample example = new BookExample();
        List<Book> list = bookMapper.selectByExample(example);
        return PageUtils.build(list);
    }

    public List<Book> findAll() {
        BookExample example = new BookExample();
        return bookMapper.selectByExample(example);
    }

    @Async
    public void asyncRun() {
        logger.error("async start");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        logger.error("async end");
    }

    @Transactional(readOnly = true)
    public List<Book> findByIsbn(String isbn) {
        BookExample example = new BookExample();
        example.createCriteria().andIsbnEqualTo(isbn);
        return bookMapper.selectByExample(example);
    }

    @Transactional
    public Integer insert(Book book) {
        bookMapper.insertSelective(book);

        try {
            book.setTitle("222");
            bookService.updateBook(book);
        } catch (Exception e) {
            System.out.println("异常");
        }
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

    //    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public Integer updateBook(Book book) {
        bookMapper.updateByPrimaryKeySelective(book);
        return book.getId();
//        throw new RuntimeException("RuntimeException");
    }
}
