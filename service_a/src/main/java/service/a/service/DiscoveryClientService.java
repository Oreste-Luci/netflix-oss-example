package service.a.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Oreste Luci
 */
@Component
public class DiscoveryClientService extends AbstractService {

    @Autowired
    private DiscoveryClient discoveryClient;

    public List<String> discoveryClient() {
        ArrayList<String> list = new ArrayList<>();

        discoveryClient.getInstances(DiscoveryClientService.CLIENT_SERVICE).forEach((ServiceInstance s) -> {
            String name = s.getServiceId() + " - " + s.getUri().toString();
            System.out.println(name);
            list.add(name);
        });

        return list;
    }
}
