package service.a.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import service.a.bean.MessageBean;

import java.util.List;

/**
 * @author Oreste Luci
 */
@Component
public class RestTemplateService {

    @Autowired
    private RestTemplate restTemplate;

    public void restTemplate() {
        // use the "smart" Eureka-aware RestTemplate
        ResponseEntity<List<MessageBean>> exchange =
                this.restTemplate.exchange(
                        "http://service-b/message",
                        HttpMethod.GET,
                        null,
                        new ParameterizedTypeReference<List<MessageBean>>() {
                        },
                        (Object) "mstine");

        exchange.getBody().forEach(System.out::println);
    }
}
