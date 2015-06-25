package com.service.traffic.boot;

/**
 * Created by mnavarro on 25.06.15.
 */

import com.service.traffic.service.GeneratorService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import java.util.Random;
import java.util.stream.IntStream;

/**
 * @author Oreste Luci
 */
@EnableAutoConfiguration
@SpringBootApplication
@EnableDiscoveryClient
@EnableCircuitBreaker
@EnableFeignClients(value = "com.service.traffic.*")
@ComponentScan("com.service.traffic.*")
public class ApplicationTraffic {

    public static void main(String[] args) {
        SpringApplication.run(ApplicationTraffic.class, args);
    }

    @Bean
    CommandLineRunner init(GeneratorService generatorService) {
        return args -> {
            IntStream.iterate(0, i -> i + 2).limit(100).forEach(i -> {
                generatorService.callRandomMethod();

                try {
                    Thread.sleep(new Random().nextInt(3000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        };
    }
}
