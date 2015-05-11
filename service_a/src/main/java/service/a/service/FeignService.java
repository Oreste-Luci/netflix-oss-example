package service.a.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
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
@Component
@EnableFeignClients
public class FeignService {

    @Autowired
    private ServiceBClient serviceBClient;

    public MessageBean feignClient() {
        String uuid = UUID.randomUUID().toString();
        MessageBean messageBean = serviceBClient.getMessage(uuid);
        System.out.println(messageBean.toString());
        return messageBean;
    }


    @FeignClient("service-b")
    public interface ServiceBClient {

        @RequestMapping(method = RequestMethod.GET, value = "/echo?msg={msg}")
        MessageBean getMessage(@PathVariable(value = "msg") String msg);
    }
}