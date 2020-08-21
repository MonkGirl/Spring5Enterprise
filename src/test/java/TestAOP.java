import com.monkgirl.spring5.chapter3.enhancer.SpringAfterAdvice;
import com.monkgirl.spring5.chapter3.enhancer.SpringAroundAdvice;
import com.monkgirl.spring5.chapter3.enhancer.SpringBeforeAdvice;
import com.monkgirl.spring5.chapter3.enhancer.SpringThrowAdvice;
import com.monkgirl.spring5.entities.*;
import com.monkgirl.spring5.interfaces.Management;
import org.junit.jupiter.api.Test;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextLoader;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.web.context.WebApplicationContext;

import java.util.concurrent.TimeUnit;

/**
 * @author MissYoung
 * @version 0.1
 * @date 2020-08-13 17:26
 * @description
 */
@SpringJUnitConfig(locations = "classpath:spring-mvc.xml")
class TestAOP {

    @Autowired
    private Apple apple;
    @Autowired
    private Banana banana;
    @Autowired
    private Desk desk;
    @Autowired
    private Table table;
    @Autowired
    private Waiter waiter;
    @Autowired
    private SpringBeforeAdvice beforeAdvice;
    @Autowired
    private SpringAfterAdvice afterAdvice;
    @Autowired
    private SpringAroundAdvice aroundAdvice;
    @Autowired
    private SpringThrowAdvice throwAdvice;
//    @Autowired
//    private Waiter waiterProxy;

    @Test
    void testAopAdvice() throws InterruptedException {
        apple.eat();
        TimeUnit.SECONDS.sleep(3);
        banana.eat();
    }

    @Test
    void testCglibXmlAspect() throws InterruptedException {
        desk.location();
        table.location();
    }

    @Test
    void testBeforeAdvice() throws Exception {
        // Spring 提供的代理工厂
        //ProxyFactory factory = new ProxyFactory();
        //factory.setTarget(waiter);
        //factory.addAdvice(beforeAdvice);
        //factory.addAdvice(afterAdvice);
        //factory.addAdvice(aroundAdvice);
        //factory.addAdvice(throwAdvice);
        //Waiter waiter = (Waiter) factory.getProxy();
        //waiter.serve("Icarus");
        //waiter.driving("Aurora");
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:spring-mvc.xml");
        Waiter waiterProxy = (Waiter) ac.getBean("waiterProxy");
        Management management = (Management) waiterProxy;
        management.manage("boss");
    }
}
