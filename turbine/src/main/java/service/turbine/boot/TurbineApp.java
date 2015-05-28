package service.turbine.boot;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.turbine.amqp.EnableTurbineAmqp;

/**
 * @author Oreste Luci
 */
@SpringBootApplication
@EnableAutoConfiguration
@EnableTurbineAmqp
//@EnableDiscoveryClient
@EnableEurekaClient
public class TurbineApp {

    public static void main(String[] args) {
        new SpringApplicationBuilder(TurbineApp.class).run(args);
    }
}
