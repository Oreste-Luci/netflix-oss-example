package service.turbine.boot;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.turbine.EnableTurbine;
import org.springframework.context.annotation.Configuration;

/**
 * @author Oreste Luci
 */
@SpringBootApplication
@EnableTurbine
@EnableDiscoveryClient
public class TurbineApp {

    public static void main(String[] args) {
        new SpringApplicationBuilder(TurbineApp.class).run(args);
    }
}
