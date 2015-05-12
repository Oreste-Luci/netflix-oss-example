package service.a.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import service.a.bean.MessageBean;

import java.util.UUID;

/**
 * @author Oreste Luci
 */
@EnableAutoConfiguration
@RefreshScope
@Component
public class FeignService extends AbstractService {

    @Value("${default.message:FeignService}")
    String message;

    @Autowired
    private ServiceBClient serviceBClient;

    public MessageBean feignClient() {
        String uuid = message + " " + UUID.randomUUID().toString();
        MessageBean messageBean = serviceBClient.getMessage(uuid);
        System.out.println(messageBean.toString());
        return messageBean;
    }


    @FeignClient(FeignService.CLIENT_SERVICE)
    public interface ServiceBClient {

        @RequestMapping(method = RequestMethod.GET, value = "/echo?msg={msg}")
        MessageBean getMessage(@PathVariable(value = "msg") String msg);
    }
}
