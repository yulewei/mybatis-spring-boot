package com.example.common;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * @author yulewei on 2020/7/16
 */
public class PageUtils {

    /**
     * 将由 pagehelper 分页查询得到的 {@link com.github.pagehelper.Page} 转换为 {@link Page}。若参数并不是 {@link com.github.pagehelper.Page} 对象，也支持转换
     */
    @SuppressWarnings("unchecked")
    public static <E> Page<E> build(List<E> list) {
        Page<E> tmp = new Page<>();
        if (list instanceof com.github.pagehelper.Page) {
            com.github.pagehelper.Page page = (com.github.pagehelper.Page) list;
            tmp.setPage(page.getPageNum());
            tmp.setLimit(page.getPageSize());

            tmp.setPages(page.getPages());
            tmp.setItems(page);
            tmp.setCount(page.getTotal());
        } else if (list instanceof Collection) {
            tmp.setPage(1);
            tmp.setLimit(list.size());

            tmp.setPages(tmp.getLimit() > 0 ? 1 : 0);
            tmp.setItems(list);
            tmp.setCount(list.size());
        }
        return tmp;
    }

    /**
     * 将 pageInfo 中的 items 替换为 realList
     *
     * @param realList 实际的列表内容
     * @param page     分页信息
     */
    @SuppressWarnings("unchecked")
    public static <E> Page<E> build(List<E> realList, Page page) {
        Page<E> tmp = new Page<>();
        tmp.setItems(realList);
        tmp.setPage(page.getPage());
        tmp.setLimit(page.getLimit());
        tmp.setPages(page.getPages());
        tmp.setCount(page.getCount());
        return tmp;
    }

    /**
     * 将分页获得的 list、当前页、总记录数，包裹成 PageInfo 对象
     */
    public static <E> Page<E> build(List<E> pageList, int page, int limit, long count) {
        Page<E> tmp = new Page<>();
        tmp.setItems(pageList);
        tmp.setPage(page);
        tmp.setLimit(limit);
        tmp.setCount(count);
        if (limit == 0) {
            tmp.setPages(0);
        } else {
            tmp.setPages((int) (count / limit + ((count % limit == 0) ? 0 : 1)));
        }
        return tmp;
    }

    public static <E> Page<E> empty() {
        return PageUtils.build(Collections.emptyList());
    }
}
