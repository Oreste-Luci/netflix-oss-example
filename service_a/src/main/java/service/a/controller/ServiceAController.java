package service.a.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import service.a.bean.MessageBean;
import service.a.service.DiscoveryClientService;
import service.a.service.FeignService;
import service.a.service.RestTemplateService;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author Oreste Luci
 */
@RestController
public class ServiceAController {

    @Autowired
    private DiscoveryClientService discoveryClientService;

    @Autowired
    private RestTemplateService restTemplateService;

    @Autowired
    private FeignService feignService;

    private final AtomicLong counter = new AtomicLong();

    @RequestMapping(
            value = "/test",
            method= RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public MessageBean test() {
        System.out.println(counter.incrementAndGet() + ". ServiceBController.test");
        return new MessageBean("Service A");
    }

    @RequestMapping(
            value = "/discoveryClient",
            method= RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public List<String> discoveryClient() {
        System.out.println(counter.incrementAndGet() + ". ServiceBController.discoveryClient");
        return discoveryClientService.discoveryClient();
    }

    @RequestMapping(
            value = "/restTemplate",
            method= RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public MessageBean restTemplate() {
        System.out.println(counter.incrementAndGet() + ". ServiceBController.restTemplate");
        return restTemplateService.restTemplate();
    }

    @RequestMapping(
            value = "/restTemplate2",
            method= RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public @ResponseBody MessageBean restTemplate2() {
        System.out.println(counter.incrementAndGet() + ". ServiceBController.restTemplate2");
        return restTemplateService.restTemplate2();
    }

    @RequestMapping(
            value = "/feign",
            method= RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public MessageBean feignClient() {
        System.out.println(counter.incrementAndGet() + ". ServiceBController.feignClient");
        return feignService.feignClient();
    }

}
