import com.monkgirl.spring5.chapter2.service.Something;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author MissYoung
 * @version 0.1
 * @description
 * @date 2020-04-04 19:31:25
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-mvc.xml")
public class TestSpring {

    private Something something;

    @Autowired
    @Qualifier("apple")
    public void setSomething(Something something) {
        this.something = something;
    }

    @Test
    public void testPerson() {
        something.doSomething();
    }
}
