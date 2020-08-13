import com.monkgirl.spring5.chapter3.entities.Dog;
import com.monkgirl.spring5.chapter3.interfaces.Animal;
import com.monkgirl.spring5.chapter3.proxy.AnimalInvocationHandler;
import org.junit.jupiter.api.Test;

/**
 * @author MissYoung
 * @version 0.1
 * @date 2020-08-12 16:52
 * @description
 */
class TestProxy {
    @Test
    void testProxy(){
        AnimalInvocationHandler handler = new AnimalInvocationHandler();
        Dog dog = new Dog();
        dog.setName("Black Bean");
        System.out.println(dog);
        System.out.println(dog.getName());
        Animal proxy = (Animal) handler.bind(dog);
        System.out.println(proxy);
        System.out.println(proxy);
        proxy.eat();
    }
}
