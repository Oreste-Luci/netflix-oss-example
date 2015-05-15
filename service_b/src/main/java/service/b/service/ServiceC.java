package service.b.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import service.b.bean.MessageBean;

import java.util.UUID;

/**
 * @author Oreste Luci
 */
@Component
public class ServiceC {

    @Autowired
    private ServiceCClient serviceCClient;

    @HystrixCommand(fallbackMethod = "fallback")
    public MessageBean callServiceC(String msg) {
        String uuid = UUID.randomUUID().toString();
        MessageBean messageBean = serviceCClient.getMessage(uuid);
        System.out.println(messageBean.toString());
        return messageBean;
    }

    private MessageBean fallback(String msg) {
        MessageBean messageBean = new MessageBean("Fallback Method " + msg);
        System.out.println(messageBean);
        return messageBean;
    }

    @FeignClient("serviceC")
    public interface ServiceCClient {

        @RequestMapping(method = RequestMethod.GET, value = "/echo?msg={msg}")
        MessageBean getMessage(@PathVariable(value = "msg") String msg);
    }
}
