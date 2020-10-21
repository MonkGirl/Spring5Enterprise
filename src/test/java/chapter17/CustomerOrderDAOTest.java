package chapter17;

import com.alibaba.fastjson.JSON;
import com.monkgirl.spring5.chapter17.dao.CustomerOrderDAO;
import com.monkgirl.spring5.chapter17.entities.CustomerOrder;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

/**
 * @author MissYoung
 * @version 0.1
 * @date 2020-10-12 17:20
 * @description
 */
@SpringJUnitConfig(locations = "classpath:spring/spring-mvc.xml")
public class CustomerOrderDAOTest {
    @Autowired
    private CustomerOrderDAO customerOrderDAO;

    @Test
    public void testSave() {
        CustomerOrder customerOrder_1 = new CustomerOrder();
        customerOrder_1.setId(1);
        customerOrder_1.setAmount(100);
        customerOrderDAO.save(customerOrder_1);
        CustomerOrder customerOrder_2 = new CustomerOrder();
        customerOrder_2.setId(2);
        customerOrder_2.setAmount(200);
        customerOrderDAO.save(customerOrder_2);
        CustomerOrder customerOrder_3 = new CustomerOrder();
        customerOrder_3.setId(3);
        customerOrder_3.setAmount(300);
        customerOrderDAO.save(customerOrder_3);
    }

    @Test
    public void testQuery() {
        System.out.println("订单1=" + JSON.toJSONString(customerOrderDAO.query(1)));
        System.out.println("订单2=" + JSON.toJSONString(customerOrderDAO.query(2)));
        System.out.println("订单3=" + JSON.toJSONString(customerOrderDAO.query(3)));
    }
}
