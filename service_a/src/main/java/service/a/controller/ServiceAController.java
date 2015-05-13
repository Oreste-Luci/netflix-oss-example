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

    @RequestMapping(
            value = "/test",
            method= RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public MessageBean test() {
        return new MessageBean("Service A");
    }

    @RequestMapping(
            value = "/discoveryClient",
            method= RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public List<String> discoveryClient() {
        return discoveryClientService.discoveryClient();
    }

    @RequestMapping(
            value = "/restTemplate",
            method= RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public MessageBean restTemplate() {
        return restTemplateService.restTemplate();
    }

    @RequestMapping(
            value = "/restTemplate2",
            method= RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public @ResponseBody MessageBean restTemplate2() {
        return restTemplateService.restTemplate2();
    }

    @RequestMapping(
            value = "/feign",
            method= RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public MessageBean feignClient() {
        return feignService.feignClient();
    }

}
