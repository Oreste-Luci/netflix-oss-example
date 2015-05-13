#Netflix OSS Example

##Introduction

This repo contains an example of Sping cloud (Netflix OSS) micro-services architecture.

The main objective is to test how the micro-services use the discovery service (Eureka), the configuration service and the load balancing (Ribbon).
 
The example contains the following components:

1. [Eureka Service] (https://github.com/Oreste-Luci/netflix-oss-example/tree/master/eureka-server)
2. [Config Service] (https://github.com/Oreste-Luci/netflix-oss-example/tree/master/config-service)
3. [Microservice B: This is the server micro-service] (https://github.com/Oreste-Luci/netflix-oss-example/tree/master/service_b)
4. [Microservice A: This is the client micro-service] (https://github.com/Oreste-Luci/netflix-oss-example/tree/master/service_a)

The services can be started in any other but it recommended to start them in above order.

##Further Reading

* [Spring Cloud] (http://projects.spring.io/spring-cloud/spring-cloud.html)
* [Dynamic configuration management with Spring Cloud Config] (http://qiita.com/making@github/items/704d8e254e03c5cce546)
* [Spring Cloud Netflix] (http://cloud.spring.io/spring-cloud-netflix/spring-cloud-netflix.html)
* [Microservice Registration and Discovery with Spring Cloud and Netflix's Eureka] (https://spring.io/blog/2015/01/20/microservice-registration-and-discovery-with-spring-cloud-and-netflix-s-eureka)
* [Netflix Ribbon] (https://github.com/Netflix/ribbon/wiki)
