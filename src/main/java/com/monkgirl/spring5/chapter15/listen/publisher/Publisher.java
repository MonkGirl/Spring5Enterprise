package com.monkgirl.spring5.chapter15.listen.publisher;

import com.monkgirl.spring5.chapter15.client.ZooKeeperClient;
import org.apache.curator.framework.CuratorFramework;
import org.apache.zookeeper.data.Stat;

/**
 * @author MissYoung
 * @version 0.1
 * @date 2020-10-02 20:48
 * @description
 */
public class Publisher {
    private final ZooKeeperClient zooKeeperClient;

    public Publisher(ZooKeeperClient zooKeeperClient) {
        this.zooKeeperClient = zooKeeperClient;
    }

    public void publish(String path, String data) {
        try {
            CuratorFramework framework = zooKeeperClient.getCuratorFramework();
            Stat stat = framework.checkExists().forPath(path);
            if (stat == null) {
                framework.create().creatingParentContainersIfNeeded().forPath(path, data.getBytes());
            } else {
                framework.setData().forPath(path, data.getBytes());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
