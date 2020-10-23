package chapter19;

import org.junit.jupiter.api.Test;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.io.IOException;

/**
 * @author MissYoung
 * @version 0.1
 * @date 2020-10-21 12:32
 * @description
 */
@SpringJUnitConfig(locations = "classpath:dubbo/spring-dubbo-provider.xml")
class DubboProviderTest {
    @Test
    void startProvider() throws IOException {
        System.out.println("Dubbo Provider started successfully...");
        System.in.read();
    }
}
