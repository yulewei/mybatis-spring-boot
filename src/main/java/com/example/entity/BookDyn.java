package com.example.entity;

import java.io.Serializable;
import java.util.Date;
import javax.annotation.Generated;
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
public class BookDyn implements Serializable {
    @Generated(value="mbg", comments="book.id")
    private Integer id;

    @Generated(value="mbg", comments="book.isbn")
    private String isbn;

    @Generated(value="mbg", comments="book.title")
    private String title;

    @Generated(value="mbg", comments="book.author")
    private String author;

    @Generated(value="mbg", comments="book.price")
    private String price;

    @Generated(value="mbg", comments="book.publish_date")
    private Date publishDate;

    /**
     * @mbg.generated
     */
    private static final long serialVersionUID = 1L;
}