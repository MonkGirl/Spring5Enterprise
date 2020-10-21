package chapter17;

import com.alibaba.fastjson.JSON;
import com.monkgirl.spring5.chapter12.dao.CustomerDAO;
import com.monkgirl.spring5.chapter12.entity.Customer;
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
class TestMyCat {
    private CustomerDAO customerDAO;

    @Autowired
    public void setCustomerDAO(CustomerDAO customerDAO) {
        this.customerDAO = customerDAO;
    }

    @Test
    void testSave(){
        Customer customer1 = new Customer();
        customer1.setId(1);
        customer1.setName("Michael");
        customer1.setPhone("13568957845");
        customerDAO.save(customer1);

        Customer customer2 = new Customer();
        customer2.setId(2);
        customer2.setName("Tom");
        customer2.setPhone("13784785125");
        customerDAO.save(customer2);
    }
    
    @Test
    void testQuery(){
        System.out.println("Customer1 = " + JSON.toJSONString(customerDAO.query(1)));
        System.out.println("Customer2 = " + JSON.toJSONString(customerDAO.query(2)));
    }
}
