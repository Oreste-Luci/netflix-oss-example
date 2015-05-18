package service.b.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import service.b.bean.MessageBean;
import service.b.service.MessageService;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @author Oreste Luci
 */
@EnableAutoConfiguration
@RefreshScope
@RestController
public class ServiceBController {

    @Value("${default.message:Service B }")
    String message;

    @Autowired
    private MessageService messageService;

    private final AtomicLong counter = new AtomicLong();

    @RequestMapping(
            value = "/test",
            method= RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public MessageBean test() {
        return new MessageBean("Service B");
    }

    @RequestMapping(
            value = "/processMsg",
            method= RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public MessageBean processMsg(@RequestParam(value="msg", required=false, defaultValue="ServiceB") String msg) {

        System.out.println(counter.incrementAndGet() + ". ServiceBController.echo: " + msg);
        return messageService.callServiceC(msg);
    }
}
