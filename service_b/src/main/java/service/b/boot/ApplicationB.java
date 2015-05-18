package service.b.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author Oreste Luci
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients(value = "service.b.*")
@ComponentScan("service.b.*")
public class ApplicationB {
    public static void main(String[] args) {
        SpringApplication.run(ApplicationB.class, args);
    }
}
