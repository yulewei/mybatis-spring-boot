package com.example.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.example.entity.Book;
import com.example.entity.criteria.BookExample;

@Mapper
public interface IBookDAO extends IBaseDAO<Book, BookExample> {
}