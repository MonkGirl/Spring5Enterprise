package chapter14;

import com.alibaba.fastjson.JSON;
import com.monkgirl.spring5.chapter14.entities.Book;
import com.monkgirl.spring5.chapter14.service.BookService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.math.BigDecimal;

/**
 * @author MissYoung
 * @version 0.1
 * @date 2020-09-29 19:37
 * @description
 */
@SpringJUnitConfig(locations = "classpath:spring/spring-mvc.xml")
class TestBookService {

    private BookService bookService;

    @Autowired
    public void setBookService(BookService bookService) {
        this.bookService = bookService;
    }

    @Test
    void tesBookServiceImpl(){
        Book book = new Book();
        book.setName("Thinking In Java");
        book.setPrice(BigDecimal.valueOf(138.00));
        bookService.save(book);
    }

    @Test
    void testQuery(){
        Book book = bookService.query(1);
        System.out.println("bookId=1的详情：" + JSON.toJSONString(book));
    }
}
