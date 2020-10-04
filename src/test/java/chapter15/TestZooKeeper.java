package chapter15;

import com.monkgirl.spring5.chapter15.client.ZooKeeperClient;
import org.apache.zookeeper.CreateMode;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

/**
 * @author MissYoung
 * @version 0.1
 * @date 2020-09-30 16:59
 * @description
 */
@SpringJUnitConfig(locations = "classpath:spring/spring-mvc.xml")
class TestZooKeeper {
    private ZooKeeperClient zooKeeperClient;

    @Autowired
    public void setZooKeeperClient(ZooKeeperClient zooKeeperClient) {
        this.zooKeeperClient = zooKeeperClient;
    }

    @Test
    void test() {
        String path = "/Spring5/test";
        zooKeeperClient.save(path, "Spring 5 ZooKeeper Test", CreateMode.PERSISTENT);
        String data = zooKeeperClient.query(path);
        System.out.println("data = " + data);
    }
}
