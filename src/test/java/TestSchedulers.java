import com.monkgirl.spring5.chapter6.webflux.SchedulerOperationDemo;
import org.junit.jupiter.api.Test;

import java.util.concurrent.TimeUnit;

/**
 * @author MissYoung
 * @version 0.1
 * @date 2020-09-07 16:13
 * @description
 */
class TestSchedulers {
    @Test
    void testOperation() throws InterruptedException {
        SchedulerOperationDemo demo = new SchedulerOperationDemo();
        System.out.println(demo.hello());
        System.out.println("Sync-----------");
        demo.helloAsync();
        System.out.println("Async-----------");
        TimeUnit.SECONDS.sleep(4);
    }
}
