package com.example.entity;

import com.example.common.Base;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 书籍表
 * 
 * book
 *
 * @mbg.generated
 */
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Book extends Base {
    /**
     *
     * book.id
     */
    private Integer id;

    /**
     * isbn
     *
     * book.isbn
     */
    private String isbn;

    /**
     * 书名
     *
     * book.title
     */
    private String title;

    /**
     * 作者
     *
     * book.author
     */
    private String author;

    /**
     * 定价
     *
     * book.price
     */
    private String price;

    /**
     * 出版时间
     *
     * book.publish_date
     */
    private Date publishDate;
}