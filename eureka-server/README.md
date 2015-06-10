#Netflix OSS Example - Eureka

##Introduction

This module creates an Eureka server to be used by the services. By default it it configures to run in localhost.

##Quick Start

To compile:

```ShellSession
mvn clean package
```

To execute:

```ShellSession
java -jar target/eureka-service.jar
```

To open the Eureka status page:

```
http://localhost:8761/
```

Once the Eureka service is running it is ready to accept the registration of other services. This will happen automatically for all the services that are configured to register with the Eureka server.


##Configuration

The configuration is split up in two files.

###bootstrap.yml

This is the first file that is read by the application when it starts. Here we configure the name of the application.

###application.yml

In this file we place the configuration for the Eureka server. Things like the port it should use, whether it should register itself as a service, etc. More information can be found here [Netflix Eureka](https://github.com/Netflix/eureka).

##Docker

Docker images can be created to test deploying the server into a different environment. The script to create the Docker image is contained in the Dockerfile.
 
###To create the image

The following commands creates the latest jar file and creates a Docker image called ```eureka-server```.

```
mvn clean package
docker build -t eureka-server .
```

###To run the container

The following command starts a new container named ```eureka-server``` from the ```eureka-server``` image. It maps port 8761 so that it can be reachable.

```
docker run -p 8761:8761 -d --name eureka-server eureka-server
```
