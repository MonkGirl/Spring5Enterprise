package chapter17;

import com.alibaba.fastjson.JSON;
import com.monkgirl.spring5.chapter17.dao.ItemDAO;
import com.monkgirl.spring5.chapter17.entities.Item;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

/**
 * @author MissYoung
 * @version 0.1
 * @date 2020-10-12 17:20
 * @description
 */
@SpringJUnitConfig(locations = "classpath:mycat/spring-mycat.xml")
class ItemDAOTest {
    @Autowired
    private ItemDAO itemDAO;
    @Test
    void testSave() {
        Item item_1 = new Item();
        item_1.setId(1);
        item_1.setValue(100);
        itemDAO.save(item_1);
        Item item_2 = new Item();
        item_2.setId(2);
        item_2.setValue(200);
        itemDAO.save(item_2);
        Item item_3 = new Item();
        item_3.setId(3);
        item_3.setValue(300);
        itemDAO.save(item_3);
    }

    @Test
    void testQuery() {
        System.out.println("商品1=" + JSON.toJSONString(itemDAO.query(1)));
        System.out.println("商品2=" + JSON.toJSONString(itemDAO.query(2)));
        System.out.println("商品3=" + JSON.toJSONString(itemDAO.query(3)));
    }
}
