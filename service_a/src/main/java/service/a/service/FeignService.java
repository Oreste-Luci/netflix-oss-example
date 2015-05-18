package service.a.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
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
public class FeignService extends AbstractService {

    @Autowired
    private ServiceBClient serviceBClient;

    @HystrixCommand(fallbackMethod = "fallback")
    public MessageBean feignClient() {
        String uuid = UUID.randomUUID().toString();
        MessageBean messageBean = serviceBClient.getMessage(uuid);
        return messageBean;
    }

    private MessageBean fallback() {
        MessageBean messageBean = new MessageBean("Fallback Method");
        System.out.println(messageBean);
        return messageBean;
    }

    @FeignClient(FeignService.CLIENT_SERVICE)
    public interface ServiceBClient {

        @RequestMapping(method = RequestMethod.GET, value = "/processMsg?msg={msg}")
        MessageBean getMessage(@PathVariable(value = "msg") String msg);
    }
}
