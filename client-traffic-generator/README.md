#Netflix OSS Example - Client Traffic generator

##Introduction

This is a very simple micro-service that simple make 198 calls to [ServiceA](https://github.com/Oreste-Luci/netflix-oss-example/tree/master/service_b) with random sleep intervals

##Quick Start
 
To compile:
 
```ShellSession
mvn clean package
```
 
To execute:
 
```ShellSession
java -jar target/client-traffic-generator.jar
```
 
This will start the microservice client traffic generator in an automatically assigned port and register it with eureka, and will launch the request randomly
 
To see this module working open the [Spring cloud dashboard](https://github.com/Oreste-Luci/netflix-oss-example/tree/master/spring-cloud-dashboard) and click on a registered application's circuit breaking graphic.

 
##Configuration

###bootstrap.yml

This file contains the application name and the configuration service location.

###application.yml

Contains the Actuator and the Eureka service configurations. 


##Reloading Configuration

If a change is made to a configuration file in the repo, the change will not be automatically be reflected in the micro-service since it is cached. 
To reload the configuration you must post a refresh instruction to every micro-service that reads from the configuration service.

```ShellSession
curl -X POST http://localhost:<replace_with_service_port>/refresh
```

The service should reply with the changes that have been loaded.

##Actuator

Spring Boot Actuator provides a series of endpoints to monitor and manage the service. In the case of Service B you can see all the environment properties by calling the env endpoint, eg:

```
http://localhost:<replace_with_service_port>/env
```

Another endpoint you can call to get app info is ```/info``` (in this example is admin since it was configured in the application.yml file). 
This will display the info that has been added in the properties files served by the configuration server. This information can also be added in the ```application.yml``` file as in the case of service A.


You can find more about actuator and all the endpoints it has [here] (http://docs.spring.io/spring-boot/docs/current-SNAPSHOT/reference/htmlsingle/#production-ready).


##Docker

Docker images can be created to test deploying the server into a different environment. The script to create the Docker image is contained in the Dockerfile.
 
###To create the image

The following commands creates the latest jar file and creates a Docker image called ```service-c```.

```
mvn clean package
docker build -t client-traffic-generator .
```

###To run the container

The following command starts a new container named ```client-traffic-generator``` from the ```client-traffic-generator``` image. It maps port 9094 so that it can be reachable.

```
docker run -p 9094:9094 -d --name client-traffic-generator -e "spring.profiles.active=docker" --add-host eureka-server-docker:<eureka server ip>  --add-host config-service-docker:<config service ip> client-traffic-generator
```

To find out the ip of the eureka can config service you can use the following command:
 
```
docker inspect <container name>
```
 
