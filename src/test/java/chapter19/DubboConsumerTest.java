package chapter19;

import com.monkgirl.spring5.chapter19.service.HelloService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.util.concurrent.TimeUnit;

/**
 * @author MissYoung
 * @version 0.1
 * @date 2020-10-21 12:34
 * @description
 */
@SpringJUnitConfig(locations = "classpath:dubbo/spring-dubbo-consumer.xml")
class DubboConsumerTest {
    private HelloService helloService;

    @Autowired
    public void setHelloService(HelloService helloService) {
        this.helloService = helloService;
    }

    @Test
    void testConsumer() throws InterruptedException {
        for(int i=0;i<10;i++){
            TimeUnit.SECONDS.sleep(1);
            System.out.println(helloService.sayHello("Icarus"));
        }
    }
}
