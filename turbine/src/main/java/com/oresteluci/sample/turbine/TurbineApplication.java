package com.oresteluci.sample.turbine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.turbine.amqp.EnableTurbineAmqp;

/**
 * @author Oreste Luci
 */
@SpringBootApplication
@EnableEurekaClient
@EnableTurbineAmqp
public class TurbineApplication {

	public static void main(String[] args) {
		SpringApplication.run(TurbineApplication.class, args);
	}
}
