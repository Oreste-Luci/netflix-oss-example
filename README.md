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
* http://projects.spring.io/spring-cloud/spring-cloud.html