package service.a.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import service.a.bean.MessageBean;

import java.net.URI;
import java.util.UUID;

/**
 * @author Oreste Luci
 */
@Component
public class RestTemplateService {

    @Autowired
    private LoadBalancerClient loadBalancer;

    @Autowired
    private RestTemplate restTemplate;

    public void restTemplate() {

        // use the "smart" Eureka-aware RestTemplate
        ResponseEntity<MessageBean> responseEntity = this.restTemplate.exchange("http://service-b/echo",
                        HttpMethod.GET,
                        null,
                        MessageBean.class);

        System.out.println(responseEntity.getBody().getMessage());
    }

    public MessageBean restTemplate2() {

        String uuid = UUID.randomUUID().toString();

        ServiceInstance instance = loadBalancer.choose("service-b");

        URI serviceURI = instance.getUri();

        String url = serviceURI.toString() + "/echo?msg=" + uuid;

        RestTemplate restTemplate = new RestTemplate();

        MessageBean message = restTemplate.getForObject(url, MessageBean.class);

        System.out.println(message.toString());

        return message;
    }
}
