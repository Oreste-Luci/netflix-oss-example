package spring_boot.admin.boot;

import de.codecentric.boot.admin.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

/**
 * @author Oreste Luci
 */
@SpringBootApplication
@Configuration
@EnableAutoConfiguration
@EnableAdminServer
public class SpringBootAdminApp {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootAdminApp.class, args);
    }
}
