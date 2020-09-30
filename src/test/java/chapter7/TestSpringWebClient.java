package chapter7;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

/**
 * @author MissYoung
 * @version 0.1
 * @date 2020-09-14 15:01
 * @description
 */
@SpringJUnitConfig(locations = "classpath:spring/spring-mvc.xml")
class TestSpringWebClient {

    @Autowired
    private RestTemplate restTemplate;

    @Test
    void testDate(){
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(
                "http://127.0.0.1:8080/Spring5Enterprise/date/currentDate", String.class
        );
        if(responseEntity.getStatusCodeValue() == 200){
            System.out.println(responseEntity.getBody());
        }
    }

    @Test
    void testWebFluxDate(){
        WebClient webClient = WebClient.create("http://127.0.0.1:8080");
        Mono<String> resp = webClient.get().uri("/Spring5Enterprise/date/webflux/getCurrentDate").retrieve().bodyToMono(String.class);
        System.out.println(resp.block());
    }
}
