package com.monkgirl.spring5.chapter14.service.impl;

import com.alibaba.fastjson.JSON;
import com.monkgirl.spring5.chapter14.dao.BookDAO;
import com.monkgirl.spring5.chapter14.entities.Book;
import com.monkgirl.spring5.chapter14.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import redis.clients.jedis.JedisCluster;

/**
 * @author MissYoung
 * @version 0.1
 * @date 2020-09-29 17:25
 * @description
 */
@Service
public class BookServiceImpl implements BookService {
    private BookDAO bookDAO;
    private JedisCluster jedisCluster;

    @Autowired
    public void setBookDAO(BookDAO bookDAO) {
        this.bookDAO = bookDAO;
    }

    @Autowired
    public void setJedisCluster(JedisCluster jedisCluster) {
        this.jedisCluster = jedisCluster;
    }

    @Override
    public int save(Book book) {
        return bookDAO.save(book);
    }

    @Override
    public Book query(int id) {
        String cacheBook = jedisCluster.get("book_" + id);
        if (StringUtils.isEmpty(cacheBook)) {
            System.out.println("缓存中不存在此图书（bookId=" + id + "）");
            Book book = bookDAO.query(id);
            jedisCluster.setex("book_" + id, 600, JSON.toJSONString(book));
            return book;
        } else {
            System.out.println("缓存中存在此图书（bookId=" + id + "）");
            return JSON.parseObject(cacheBook, Book.class);
        }
    }
}
