package com.monkgirl.spring5.chapter15.resource;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @author MissYoung
 * @version 0.1
 * @date 2020-10-04 14:37
 * @description
 */
public class SharedResource {
    private final AtomicBoolean shareResourceInUse = new AtomicBoolean(false);

    public void use() {
        if (!shareResourceInUse.compareAndSet(false, true)) {
            throw new IllegalStateException("Needs to be used by one client at a time");
        }
        System.out.println("共享资源中。。。");
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            shareResourceInUse.set(false);
        }
    }

}
