package com.example.entity;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 书籍表
 * <p>
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
     * book.id
     *
     * @mbg.generated
     */
    private Integer id;

    /**
     * isbn
     * <p>
     * book.isbn
     *
     * @mbg.generated
     */
    private String isbn;

    /**
     * 书名
     * <p>
     * book.title
     *
     * @mbg.generated
     */
    private String title;

    /**
     * 作者
     * <p>
     * book.author
     *
     * @mbg.generated
     */
    private String author;

    /**
     * 定价
     * <p>
     * book.price
     *
     * @mbg.generated
     */
    private String price;

    /**
     * 出版时间
     * <p>
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