package chapter15;

import com.monkgirl.spring5.chapter15.client.ZooKeeperClient;
import com.monkgirl.spring5.chapter15.listen.publisher.Publisher;
import com.monkgirl.spring5.chapter15.listen.subscriber.CuratorCacheSubscriber;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.util.concurrent.TimeUnit;

/**
 * @author MissYoung
 * @version 0.1
 * @date 2020-10-02 22:30
 * @description
 */


@SpringJUnitConfig(locations = "classpath:spring/spring-mvc.xml")
class TestCurator{
    @Autowired
    private ZooKeeperClient zooKeeperClient;

    @Test
     void testCache() throws InterruptedException {
        String path = "/NodeCacheNew/PubSub";
        Publisher publisher = new Publisher(zooKeeperClient);
        //写入数据100
       // CuratorCacheSubscriber subscriber1 = new CuratorCacheSubscriber(zooKeeperClient, "订阅者1");
        //subscriber1.subscribe(path);
        CuratorCacheSubscriber subscriber2 = new CuratorCacheSubscriber(zooKeeperClient, "订阅者2");
        subscriber2.subscribe(path);
        publisher.publish(path, String.valueOf(100));
        System.out.println("----------------分割线----------------");
        //更新数据200
        publisher.publish(path, String.valueOf(200));
        publisher.publish("/NodeCacheNew/NewPubSub", String.valueOf(300));
        publisher.publish("/NodeCacheNew/PubSub/PubSub_1", String.valueOf(400));
        publisher.publish("/NodeCacheNew/PubSub/PubSub_1", String.valueOf(5400));
    }
}
