package com.monkgirl.spring5.chapter15.listen.subscriber;

import com.monkgirl.spring5.chapter15.client.ZooKeeperClient;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.recipes.cache.CuratorCache;
import org.apache.curator.framework.recipes.cache.CuratorCacheListener;

/**
 * @author MissYoung
 * @version 0.1
 * @date 2020-10-02 20:59
 * @description
 */
public class CuratorCacheSubscriber {
    private final ZooKeeperClient zooKeeperClient;

    private String name;

    public CuratorCacheSubscriber(ZooKeeperClient zooKeeperClient, String name) {
        this.zooKeeperClient = zooKeeperClient;
        this.name = name;
    }

    public void subscribe(String path) {
        CuratorFramework curatorFramework = zooKeeperClient.getCuratorFramework();
        CuratorCache curatorCache = CuratorCache.build(curatorFramework, path, CuratorCache.Options.DO_NOT_CLEAR_ON_CLOSE);
        CuratorCacheListener listener = CuratorCacheListener.builder()//.forNodeCache(() -> System.out.printf("Node changed.%n"))
                .forCreates(node -> System.out.printf("Node created: [%s:%s]%n", node.getPath(), new String(node.getData())))
                .forChanges((oldNode, node) -> System.out.printf("Node changed, Old: [%s: %s] New: [%s: %s]%n", oldNode.getPath(), new String(oldNode.getData()), node.getPath(), new String(node.getData())))
                .forDeletes(oldNode -> System.out.printf("Node deleted, Old value: [%s: %s]%n", oldNode.getPath(), new String(oldNode.getData())))
                .forInitialized(() -> System.out.printf("Cache initialized%n"))
                .build();
        curatorCache.listenable().addListener(listener);
        curatorCache.start();
    }
}
