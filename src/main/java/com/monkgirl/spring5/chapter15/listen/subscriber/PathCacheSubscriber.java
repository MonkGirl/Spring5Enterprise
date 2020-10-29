package com.monkgirl.spring5.chapter15.listen.subscriber;

import com.monkgirl.spring5.chapter15.client.ZooKeeperClient;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.recipes.cache.PathChildrenCache;

/**
 * @author MissYoung
 * @version 0.1
 * @date 2020-10-03 14:54
 * @description
 */
public class PathCacheSubscriber {
    private ZooKeeperClient zooKeeperClient;
    private String name;

    public PathCacheSubscriber(ZooKeeperClient zooKeeperClient, String name){
        this.zooKeeperClient = zooKeeperClient;
        this.name = name;
    }

    public void subscribe(String path){
        CuratorFramework curatorFramework = zooKeeperClient.getCuratorFramework();
        PathChildrenCache cache = new PathChildrenCache(curatorFramework, path, true);
    }
}
