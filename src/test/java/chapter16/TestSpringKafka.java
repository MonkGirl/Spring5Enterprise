package chapter16;

import com.monkgirl.spring5.chapter16.producer.MessageProducer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.util.concurrent.TimeUnit;

/**
 * @author MissYoung
 * @version 0.1
 * @date 2020-10-10 17:06
 * @description
 */
@SpringJUnitConfig(locations = "classpath:spring/spring-mvc.xml")
class TestSpringKafka {

    private MessageProducer messageProducer;

    @Autowired
    public void setMessageProducer(MessageProducer messageProducer) {
        this.messageProducer = messageProducer;
    }

    @Test
    void sendMessage() throws InterruptedException {
        for(int i=0; i<10;i++){
            messageProducer.send("spring-kafka-test", "Hello Spring Kafka");
        }
        TimeUnit.MILLISECONDS.sleep(1000);
    }
}
