import com.monkgirl.spring5.chapter2.lifecycle.BeanLifeCycle;
import com.monkgirl.spring5.chapter2.service.Something;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

/**
 * @author MissYoung
 * @version 0.1
 * @description
 * @date 2020-04-04 19:31:25
 */
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration("classpath:spring-mvc.xml")
//@ExtendWith(SpringExtension.class)
//@ContextConfiguration("classpath:spring-mvc.xml")
@SpringJUnitConfig(locations = "classpath:spring-mvc.xml")
class TestSpring {

    private Something something;

    private BeanLifeCycle lifeCycle;

    @Autowired
    @Qualifier("apple")
    public void setSomething(Something something) {
        this.something = something;
    }

    @Autowired
    public void setLifeCycle(BeanLifeCycle lifeCycle) {
        this.lifeCycle = lifeCycle;
    }

    @Test
    void testPerson() {
        something.doSomething();
    }

    @Test
    void testLifeCycle(){
        lifeCycle.showLifeCycle();
    }

    @Test
    void testContainerLifeCycle(){
        lifeCycle.showLifeCycle();
    }
}






