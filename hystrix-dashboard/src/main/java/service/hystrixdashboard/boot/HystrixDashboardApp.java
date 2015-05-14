package service.hystrixdashboard.boot;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Oreste Luci
 */
@Configuration
@ComponentScan
@EnableAutoConfiguration
@Controller
@EnableHystrixDashboard
public class HystrixDashboardApp {

    public static void main(String[] args) {
        new SpringApplicationBuilder(HystrixDashboardApp.class).web(true).run(args);
    }

    @RequestMapping("/")
    public String home() {
        return "forward:/hystrix";
    }
}
