package com.monkgirl.spring5.chapter11.controller;

import com.monkgirl.spring5.chapter11.pojo.Book;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author MissYoung
 * @version 0.1
 * @date 2020-09-21 17:23
 * @description
 */
@Controller
public class JsonController {
    @RequestMapping("/hello/json")
    @ResponseBody
    public Book getBook(){
        Book book = new Book();
        book.setName("Spring5");
        book.setPrice(500);
        book.setAuthor("Icarus");
        return book;
    }
}
