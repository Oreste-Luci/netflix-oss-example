package service.config.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @author Oreste Luci
 */
@EnableAutoConfiguration
@EnableDiscoveryClient
@EnableConfigServer
public class ConfigService {

    public static void main(String[] args) {
        SpringApplication.run(ConfigService.class,args);
    }
}
