package com.monkgirl.spring5.chapter15.client;

import org.apache.curator.framework.CuratorFramework;
import org.apache.zookeeper.CreateMode;

/**
 * @author MissYoung
 * @version 0.1
 * @date 2020-09-30 16:11
 * @description
 */
public class ZooKeeperClient {
    private final CuratorFramework curatorFramework;

    public ZooKeeperClient(CuratorFramework curatorFramework){
        this.curatorFramework = curatorFramework;
    }

    public CuratorFramework getCuratorFramework(){
        return curatorFramework;
    }
    public void save(String path, String data, CreateMode createMode) {
        try {
            curatorFramework.create().creatingParentContainersIfNeeded().withMode(createMode).forPath(path, data.getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String query(String path) {
        try {
            byte[] data = curatorFramework.getData().forPath(path);
            if (data != null && data.length > 0) {
                return new String(data);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
