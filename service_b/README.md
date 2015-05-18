#Netflix OSS Example - Service B

##Introduction

This is a very simple micro-service that simple forwards the calls to service C.

The purpose of this service is to server as a server to micro-service A. To test load balancing features you can instantiate this service multiple times, the auto port configuration will assign different ports.

##Quick Start
 
To compile:
 
```ShellSession
mvn clean package
```
 
To execute:
 
```ShellSession
java -jar target/service-b.jar
```
 
This will start the microservice B in an automatically assigned port and register it with eureka. To check if it has been successfully registered with eureka check the eureka status page:
 
```
http://localhost:8761/
```
 
To test the service you can do the following 
 
```ShellSession
curl http://localhost:<replace_with_service_port>/echo\?msg\=Hello | jq .
```
 
You should see the following output:
 
```json
{
  "message": "From local file Hello 8b4366d0-3d2a-4890-aaf5-9198ba643763"
}
```
 
##Configuration

###bootstrap.yml

This file contains the application name and the configuration service location.

###application.yml

Contains the Actuator and the Eureka service configurations. 


##Reloading Configuration

If a change is made to a configuration file in the repo, the change will not be automatically be reflected in the micro-service since it is cached. 
To reload the configuration you must post a refresh instruction to every micro-service that reads from the configuration service.

```ShellSession
curl -X POST http://localhost:<replace_with_service_port>/admin/refresh
```

The service should reply with the changes that have been loaded.

##Actuator

Spring Boot Actuator provides a series of endpoints to monitor and manage the service. In the case of Service B you can see all the environment properties by calling the env endpoint, eg:

```
http://localhost:<replace_with_service_port>/admin/env
```

Another endpoint you can call to get app info is ```/admin/info``` (in this example is admin since it was configured in the application.yml file). 
This will display the info that has been added in the properties files served by the configuration server. This information can also be added in the ```application.yml``` file as in the case of service A.


You can find more about actuator and all the endpoints it has [here] (http://docs.spring.io/spring-boot/docs/current-SNAPSHOT/reference/htmlsingle/#production-ready).





