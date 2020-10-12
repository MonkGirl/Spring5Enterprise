package chapter15;

import com.monkgirl.spring5.chapter15.client.DistributeClient;
import com.monkgirl.spring5.chapter15.client.ZooKeeperClient;
import com.monkgirl.spring5.chapter15.resource.SharedResource;
import org.apache.curator.utils.CloseableUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author MissYoung
 * @version 0.1
 * @date 2020-10-04 14:51
 * @description
 */
@SpringJUnitConfig(locations = "classpath:spring/spring-mvc.xml")
class TestDistributeLock {
    private static final int QTY = 5;
    private static final String PATH = "/lock/lock-";

    private ZooKeeperClient zooKeeperClient;

    @Autowired
    public void setZooKeeperClient(ZooKeeperClient zooKeeperClient) {
        this.zooKeeperClient = zooKeeperClient;
    }

    @Test
    void testLock() {
        final SharedResource sharedResource = new SharedResource();
        ExecutorService executor = Executors.newFixedThreadPool(QTY);
        for (int i = 0; i < QTY; i++) {
            final int index = i;
            Runnable task = () -> {
                try {
                    final DistributeClient client = new DistributeClient(zooKeeperClient.getCuratorFramework(), PATH, sharedResource, "Client_" + index);
                    client.doWork(10, TimeUnit.SECONDS);
                } catch (Throwable e) {
                    e.printStackTrace();
                } finally {
                    CloseableUtils.closeQuietly(zooKeeperClient.getCuratorFramework());
                }
            };
            executor.submit(task);
        }

        executor.shutdown();
        try {
            executor.awaitTermination(10, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            CloseableUtils.closeQuietly(zooKeeperClient.getCuratorFramework());
        }
    }
}
