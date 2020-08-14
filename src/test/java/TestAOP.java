import com.monkgirl.spring5.entities.Apple;
import com.monkgirl.spring5.entities.Banana;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.util.concurrent.TimeUnit;

/**
 * @author MissYoung
 * @version 0.1
 * @date 2020-08-13 17:26
 * @description
 */
@SpringJUnitConfig(locations = "classpath:spring-mvc.xml")
class TestAOP {

    private Apple apple;
    private Banana banana;

    @Autowired
    public void setApple(Apple apple) {
        this.apple = apple;
    }

    @Autowired
    public void setBanana(Banana banana) {
        this.banana = banana;
    }

    @Test
    void testAopAdvice() throws InterruptedException {
        apple.eat();
        TimeUnit.SECONDS.sleep(3);
        banana.eat();
    }
}
