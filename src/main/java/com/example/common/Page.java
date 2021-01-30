package com.example.common;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 分页结果信息
 *
 * @author yulewei on 2018/5/2
 * @see com.github.pagehelper.PageInfo
 */
@Data
public class Page<T> implements Serializable {

    /**
     * 当前页
     */
    private int page;

    /**
     * 每页的数量
     */
    private int limit;

    /**
     * 总记录数
     */
    private long count;

    /**
     * 总页数
     */
    private int pages;

    /**
     * 分页查询结果
     */
    private List<T> items;

}
