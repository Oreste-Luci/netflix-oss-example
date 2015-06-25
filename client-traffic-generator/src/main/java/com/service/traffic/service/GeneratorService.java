package com.service.traffic.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.service.traffic.bean.MessageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Random;

/**
 * Created by mnavarro on 25.06.15.
 * Randomly calls each service endpoints
 */
@Component
public class GeneratorService extends AbstractService {

    @Autowired
    private ServiceAClient serviceAClient;

    private Random random = new Random();

    @HystrixCommand(fallbackMethod = "fallback")
    public MessageBean callRandomMethod(){
        MessageBean messageBean = null;
        switch (random.nextInt(5)){
            case 0:
                messageBean = serviceAClient.feign();
                break;
            case 1:
                messageBean = serviceAClient.restTemplate();
                break;
            case 2:
                messageBean = serviceAClient.restTemplate2();
                break;
            case 3:
                messageBean = serviceAClient.test();
                break;
            case 4:
                messageBean = serviceAClient.discoveryClient();
                break;
            default:
                throw new IllegalArgumentException();
        }

        return messageBean;
    }

    private MessageBean fallback() {
        MessageBean messageBean = new MessageBean("Fallback Method");
        System.out.println(messageBean);
        return messageBean;
    }
    @FeignClient(CLIENT_SERVICE)
    public interface ServiceAClient {

        @RequestMapping(method = RequestMethod.GET, value = "/feign")
        MessageBean feign();

        @RequestMapping(method = RequestMethod.GET, value = "/restTemplate")
        MessageBean restTemplate();

        @RequestMapping(method = RequestMethod.GET, value = "/restTemplate2")
        MessageBean restTemplate2();

        @RequestMapping(method = RequestMethod.GET, value = "/discoveryClient")
        MessageBean discoveryClient();

        @RequestMapping(method = RequestMethod.GET, value = "/test")
        MessageBean test();


    }

}
