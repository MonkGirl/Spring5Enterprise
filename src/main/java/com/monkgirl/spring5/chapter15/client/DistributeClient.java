package com.monkgirl.spring5.chapter15.client;

import com.monkgirl.spring5.chapter15.resource.SharedResource;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.recipes.locks.InterProcessMutex;

import java.util.concurrent.TimeUnit;

/**
 * @author MissYoung
 * @version 0.1
 * @date 2020-10-04 14:44
 * @description
 */
public class DistributeClient {
    private final InterProcessMutex lock;
    private final SharedResource resource;
    private final String clientName;

    public DistributeClient(CuratorFramework framework, String lockPath, SharedResource resource, String clientName){
        this.resource = resource;
        this.clientName = clientName;
        this.lock = new InterProcessMutex(framework, lockPath);
    }

    public void doWork(long time, TimeUnit timeUnit){
        // 加锁，带有超时时间，超过超时时间则抛出异常
        try {
            if(!lock.acquire(time, timeUnit)){
               throw new IllegalStateException("加锁失败！");
            }
            System.out.println(clientName + "加锁成功！");
            resource.use();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            System.out.println("释放锁。。。");
            try {
                lock.release();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
