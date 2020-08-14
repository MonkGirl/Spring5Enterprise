
import com.monkgirl.spring5.chapter3.proxy.AnimalInvocationHandler;
import com.monkgirl.spring5.chapter3.proxy.CatMethodInterceptor;
import com.monkgirl.spring5.entities.Cat;
import com.monkgirl.spring5.entities.Dog;
import com.monkgirl.spring5.interfaces.Animal;
import org.junit.jupiter.api.Test;
import org.springframework.cglib.proxy.Enhancer;

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
        proxy.eat();
    }

    @Test
    void testCglibDynamicProxy(){
        Enhancer enhancer = new Enhancer();
        // 被代理类
        enhancer.setSuperclass(Cat.class);
        //设置回调
        enhancer.setCallback(new CatMethodInterceptor());
        //生成代理对象
        Cat cat = (Cat) enhancer.create();

        cat.roar();
        System.out.println(cat);
    }
}
