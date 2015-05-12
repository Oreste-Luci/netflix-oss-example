#Netflix OSS Example - Service B

##Introduction

This is a very simple micro-service that simple echoes back the received message pre-appending a string obtained from the config repository.

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
curl http://localhost:63399/echo\?msg\=Hello | jq .
```
 
You should see the following output:
 
```json
{
  "message": "From local file Hello"
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
curl -X POST http://localhost:63409/manage/refresh
```

The service should reply with the changes that have been loaded.





