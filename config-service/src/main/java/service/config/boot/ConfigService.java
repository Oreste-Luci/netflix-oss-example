package service.config.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author Oreste Luci
 */
//@EnableDiscoveryClient
//@Configuration
@EnableAutoConfiguration
@EnableConfigServer
@ComponentScan(value = "service.config.*")
public class ConfigService {

    public static void main(String[] args) {
        SpringApplication.run(ConfigService.class,args);
    }
}
