package service.a.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import service.a.service.DiscoveryClientService;

/**
 * @author Oreste Luci
 */
@RestController
public class ServiceAController {

    @Autowired
    private DiscoveryClientService discoveryClientService;

    @RequestMapping(value = "/test")
    public @ResponseBody String test() {
        return "Service A";
    }

    @RequestMapping(value = "/discoveryClient")
    public @ResponseBody String discoveryClient() {
        discoveryClientService.discoveryClient();
        return "OK";
    }
}
