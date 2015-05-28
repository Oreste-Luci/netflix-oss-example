package service.a.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
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
public class RestTemplateService extends AbstractService {

    @Autowired
    private LoadBalancerClient loadBalancer;

    @Autowired
    private RestTemplate restTemplate;

    public MessageBean restTemplate() {

        // use the "smart" Eureka-aware RestTemplate
        ResponseEntity<MessageBean> responseEntity = this.restTemplate.exchange("http://" + RestTemplateService.CLIENT_SERVICE + "/processMsg",
                        HttpMethod.GET,
                        null,
                        MessageBean.class);

        System.out.println(responseEntity.getBody().getMessage());

        return responseEntity.getBody();
    }

    @HystrixCommand(fallbackMethod = "restTemplate2Fallback")
    public MessageBean restTemplate2() {

        String uuid = UUID.randomUUID().toString();

        ServiceInstance instance = loadBalancer.choose(RestTemplateService.CLIENT_SERVICE);

        URI serviceURI = instance.getUri();

        String url = serviceURI.toString() + "/processMsg?msg=" + uuid;

        RestTemplate restTemplate = new RestTemplate();

        MessageBean message = restTemplate.getForObject(url, MessageBean.class);

        System.out.println(message.toString());

        return message;
    }

    private MessageBean restTemplate2Fallback() {
        MessageBean messageBean = new MessageBean("Fallback Method");
        System.out.println(messageBean);
        return messageBean;
    }
}
