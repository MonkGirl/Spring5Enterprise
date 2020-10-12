package com.monkgirl.spring5.chapter16.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.listener.MessageListener;
import org.springframework.stereotype.Component;

/**
 * @author MissYoung
 * @version 0.1
 * @date 2020-10-10 17:01
 * @description
 */
@Component
public class MessageConsumer implements MessageListener<String, String> {
    @Override
    public void onMessage(ConsumerRecord<String, String> record) {
        System.out.printf("监听到消息：topic=%s, value=%s%n", record.topic(), record.value());
    }
}
