package service.c.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author Oreste Luci
 */
@EnableAutoConfiguration
@SpringBootApplication
@EnableDiscoveryClient
@EnableCircuitBreaker
@ComponentScan("service.c.*")
public class ApplicationC {
    public static void main(String[] args) {
        SpringApplication.run(ApplicationC.class, args);
    }
}
