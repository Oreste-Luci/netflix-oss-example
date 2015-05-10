package service.a.service;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Component;

/**
 * @author Oreste Luci
 */
@Component
public class DiscoveryClientService {

    @Autowired
    private DiscoveryClient discoveryClient;

    public void discoveryClient() {
        discoveryClient.getInstances("service-b").forEach((ServiceInstance s) -> {
            System.out.println(ToStringBuilder.reflectionToString(s));
        });
    }
}
