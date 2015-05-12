#Netflix OSS Example - Eureka

##Introduction

This module creates an Eureka server to be used by the services. By default it it configures to run in localhost.

##Quick Start

To compile:

```ShllSession
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

##Configuration

The configuration is split up in two files.

###bootstrap.yml

This is the first file that is read by the application when it starts. Here we configure the name of the application.

###application.yml

In this file we place the configuration for the Eureka server. Things like the port it should use, whether it should register itself as a service, etc. More information can be found here [Netflix Eureka](https://github.com/Netflix/eureka).