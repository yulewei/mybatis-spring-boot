package com.example.util;

import com.github.pagehelper.Page;
import lombok.Data;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

/**
 * 分页结果信息
 *
 * @author yulewei on 2018/5/2
 * @see com.github.pagehelper.PageInfo
 */
@Data
public class PageInfo<T> implements Serializable {

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
    private long total;

    /**
     * 总页数
     */
    private int pages;

    /**
     * 总页数
     */
    private List<T> items;

    public static <E> PageInfo<E> of(List<E> page) {
        return new PageInfo<E>(page);
    }

    /**
     * 包装 Page 对象
     *
     * @param list page结果
     */
    public PageInfo(List<T> list) {
        if (list instanceof Page) {
            Page page = (Page) list;
            this.page = page.getPageNum();
            this.limit = page.getPageSize();

            this.pages = page.getPages();
            this.items = page;
            this.total = page.getTotal();
        } else if (list instanceof Collection) {
            this.page = 1;
            this.limit = list.size();

            this.pages = this.limit > 0 ? 1 : 0;
            this.items = list;
            this.total = list.size();
        }
    }

}
