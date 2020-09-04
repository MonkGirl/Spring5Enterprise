import com.monkgirl.spring5.entities.*;
import com.monkgirl.spring5.interfaces.Listener;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

/**
 * @author MissYoung
 * @version 0.1
 * @date 2020-08-18 14:33
 * @description
 */
@SpringJUnitConfig(locations = "classpath:spring-mvc.xml")
class TestAdvice {
    @Autowired
    private Person person;

    @Autowired
    @Qualifier("freshFoodFactory")
    private FreshFoodFactory factory;

    @Autowired
    @Qualifier("foodFactory")
    private FoodFactory foodFactory;

    @Autowired
    private PhoneFactory phoneFactory;

    @Autowired
    private HuaweiPhoneFactory huawei;

    //    @Autowired
//    private Computer computer;
    @Test
    void testAdvice() {
        person.say();
    }

    @Test
    void testArgs() {
        factory.make();
        factory.delivery("Fresh Food.");
        factory.testArgsAnnotation(factory);
        phoneFactory.make();
        huawei.huawei();
    }

    @Test
    void testThisAndTarget() {
        foodFactory.make();
        Listener listener = (Listener) foodFactory;
        listener.listen();
    }
}
