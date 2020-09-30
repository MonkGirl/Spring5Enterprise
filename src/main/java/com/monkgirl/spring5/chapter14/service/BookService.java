package com.monkgirl.spring5.chapter14.service;

import com.monkgirl.spring5.chapter14.entities.Book;

/**
 * @author MissYoung
 * @version 0.1
 * @date 2020-09-29 17:24
 * @description
 */
public interface BookService {
    /**
     * 保存图书
     *
     * @param book 图书
     * @return 保存图书的条数
     */
    int save(Book book);

    /**
     * 查询图书
     *
     * @param id 图书id
     * @return 图书
     */
    Book query(int id);
}
