#Netflix OSS Example

##Introduction

This repo contains an example of Sping cloud (Netflix OSS) micro-services architecture.

The main objective is to test how the micro-services use the discovery service (Eureka), the configuration service and the load balancing (Ribbon).
 
The example contains the following components:

1. [Microservice A: This is the client micro-service] (https://github.com/Oreste-Luci/netflix-oss-example/tree/master/service_a)
2. [Microservice B: This is the server micro-service] (https://github.com/Oreste-Luci/netflix-oss-example/tree/master/service_b)
3. [Eureka Service] (https://github.com/Oreste-Luci/netflix-oss-example/tree/master/eureka-server)
4. [Config Service] (https://github.com/Oreste-Luci/netflix-oss-example/tree/master/config-service)

The services can be started in any other but it recommended to start them in the followinf order:

1. Eureka Service
2. Config Service
3. Microservice B
4. MIcroservice A

