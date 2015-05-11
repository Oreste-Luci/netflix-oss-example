package service.a.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import service.a.bean.MessageBean;
import service.a.service.DiscoveryClientService;
import service.a.service.FeignService;
import service.a.service.RestTemplateService;

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

    @RequestMapping(value = "/test")
    public @ResponseBody String test() {
        return "Service A";
    }

    @RequestMapping(value = "/discoveryClient")
    public @ResponseBody String discoveryClient() {
        discoveryClientService.discoveryClient();
        return "OK";
    }

    @RequestMapping(value = "/restTemplate")
    public @ResponseBody String restTemplate() {
        restTemplateService.restTemplate();
        return "OK";
    }

    @RequestMapping(value = "/restTemplate2")
    public @ResponseBody MessageBean restTemplate2() {
        return restTemplateService.restTemplate2();
    }

    @RequestMapping(value = "/feign")
    public @ResponseBody MessageBean feignClient() {
        return feignService.feignClient();
    }
}
