package chapter19;

import com.monkgirl.spring5.chapter19.spi.SpiHelloService;

import java.util.ServiceLoader;

/**
 * @author MissYoung
 * @version 0.1
 * @date 2020-10-21 19:14
 * @description
 */
public class SpiDemo {
    public static void main(String...args){
        ServiceLoader<SpiHelloService> services = ServiceLoader.load(SpiHelloService.class);
        for(SpiHelloService service : services){
            service.say();
        }
    }
}
