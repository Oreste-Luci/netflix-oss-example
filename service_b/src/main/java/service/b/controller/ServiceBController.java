package service.b.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import service.b.bean.MessageBean;

/**
 * @author Oreste Luci
 */
@RestController
public class ServiceBController {

    @RequestMapping(value = "/test")
    public @ResponseBody String test() {
        return "Service B";
    }


    @RequestMapping(
            value = "/message",
            method= RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public MessageBean message() {
        return new MessageBean("Hello");
    }
}
