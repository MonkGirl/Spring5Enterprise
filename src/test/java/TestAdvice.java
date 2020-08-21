import com.monkgirl.spring5.entities.FreshFoodFactory;
import com.monkgirl.spring5.entities.HuaweiPhoneFactory;
import com.monkgirl.spring5.entities.Person;
import com.monkgirl.spring5.entities.PhoneFactory;
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
    private PhoneFactory phoneFactory;

    @Autowired
    private HuaweiPhoneFactory huawei;
    @Test
    public void testAdvice(){
        person.say();
    }

    @Test
    public void testArgs(){
        factory.make();
        factory.delivery("Fresh Food.");
        factory.testArgsAnnotation(factory);
        phoneFactory.make();
        huawei.huawei();
    }
}
