package com.oresteluci.sample.scdashboard;

import com.github.vanroy.cloud.dashboard.config.EnableCloudDashboard;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author Oreste Luci
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableCloudDashboard
public class SpringCloudDashboardApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringCloudDashboardApplication.class, args);
    }
}
