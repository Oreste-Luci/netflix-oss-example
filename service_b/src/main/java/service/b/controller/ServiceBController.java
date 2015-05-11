package service.b.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import service.b.bean.MessageBean;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @author Oreste Luci
 */
@RestController
public class ServiceBController {

    private final AtomicLong counter = new AtomicLong();

    @RequestMapping(value = "/test")
    public @ResponseBody String test() {
        return "Service B";
    }

    @RequestMapping(
            value = "/echo",
            method= RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public MessageBean echo(@RequestParam(value="msg", required=false, defaultValue="Hello") String msg) {

        System.out.println(counter.incrementAndGet() + ". ServiceBController.echo: " + msg);

        MessageBean messageBean = new MessageBean(msg);

        return messageBean;
    }
}
