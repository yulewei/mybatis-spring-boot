package com.example.mapper;

import com.example.entity.Book;
import com.example.entity.criteria.BookExample;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BookMapper extends BaseMapper<Book, BookExample> {
}