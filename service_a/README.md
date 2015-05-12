#Netflix OSS Example - Service A

##Introduction

This is the client micro-service. It will use Eureka to find an instance of service B and send a message to it.

##Quick Start
 
To compile and package the micro-service:
 
```ShellSession
mvn clean package
```
 
To execute:
 
```ShellSession
java -jar target/service-a.jar
```
Now the micro-service should be up and running in an auto-assigned port. You can check the Eureka status page.
  
´´´
http://localhost:8761/
´´´

If you want to start the service in a specific port you can either change the configuration file and assign a port or you can pass the **server.port** argument to the jar file.

```ShellSession
java -jar target/service-a.jar --server.port=9090
```

##Endpoints

The service has the following endpoints:

|Endpoint        |Purpose        |
|----------------|---------------|
|/test           |Just to check if the service is up|
|/discoveryClient|  |
|/restTemplate   |  |
|/restTemplate2  |  |
|/feign          |  |


##Testing the setup

