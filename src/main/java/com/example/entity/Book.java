package com.example.entity;

import java.io.Serializable;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 书籍表
 * 
 * book
 *
 * @mbg.generated
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Book implements Serializable {
    /**
     *
     * book.id
     *
     * @mbg.generated
     */
    private Integer id;

    /**
     * isbn
     *
     * book.isbn
     *
     * @mbg.generated
     */
    private String isbn;

    /**
     * 书名
     *
     * book.title
     *
     * @mbg.generated
     */
    private String title;

    /**
     * 作者
     *
     * book.author
     *
     * @mbg.generated
     */
    private String author;

    /**
     * 定价
     *
     * book.price
     *
     * @mbg.generated
     */
    private String price;

    /**
     * 出版时间
     *
     * book.publish_date
     *
     * @mbg.generated
     */
    private Date publishDate;

    /**
     * @mbg.generated
     */
    private static final long serialVersionUID = 1L;
}