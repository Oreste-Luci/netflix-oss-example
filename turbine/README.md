#Netflix OSS Example - Turbine

Turbine aggregates information from several services so that it can be viewed in one Hystrix Dashboard.
 
Turbine uses RabbitMQ to read the information from the services and then it creates the ```/turbine.stram``` endpoint with all the aggregated data.

You can find more information [here] (http://projects.spring.io/spring-cloud/spring-cloud.html#_turbine).

##Enabling services to use turbine with RabbitMQ

##RabbitMQ

To enable [RabbitMQ](https://www.rabbitmq.com/) just download it and follow the instructions to start it.

##Enabling Services for turbine

To enable Turbine monitoring through RabbitMQ in a service the ```org.springframework.cloud:spring-cloud-netflix-hystrix-amqp``` dependency has to be added to the project.
Also the Spring Boot App needs to be annotated with ```@EnableCircuitBreaker``` and the methods that are going to be monitored annotated with ```@HystrixCommand```.

##Quick Start

First start RabbitMQ.

To compile:

```ShellSession
mvn clean package
```

To execute:

```ShellSession
java -jar target/turbine.jar
``` 

The stream can be found in:

```ShellSession
http://localhost:8989/turbine.stream
```

To view the graphs for the different services add the Turbine stream to the [Hystrix Dashboard](https://github.com/Oreste-Luci/netflix-oss-example/tree/master/hystrix-dashboard).
