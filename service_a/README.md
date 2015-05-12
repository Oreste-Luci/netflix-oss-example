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
  
```ShellSession
htp://localost:8761/
```

If you want to start the service in a specific port you can either change the configuration file and assign a port or you can pass the **server.port** argument to the jar file.

```ShellSession
java -jar target/service-a.jar --server.port=9090
```

##Endpoints

The service has the following endpoints:

|Endpoint        |Purpose        |
|----------------|---------------|
|/test           |Just to check if the service is up|
|/discoveryClient|It returns a list of Service B instances obtained with DiscoveryClient which in turns obtains them from Eureka  |
|/restTemplate   |Uses RestTemplate to send the message to service B  |
|/restTemplate2  |Another way to use RestTemplate to send a message to service B  |
|/feign          |Uses feign to send a message service B  |


##Testing the setup

To test the setup you must have running Eureka, Config Service, Service B and Service A. You can check Eureka status page to see that they are all up.

###Feign

The following command will call service A which will in turn call Service B who will use the Configuration Service to pre-append a message to the inpur string from Service A.

```
crl http://localhost:9090/feign | jq .
```

You should see a response like this one:

```
{
  "message": "From local file 4a3d23f9-df76-44b0-b9db-ccc00ad50c0a"
}
```

####Load Balancing

Start more than one instance of service B and wait for it to be registered in Eureka (then after 30 seconds it will be obtained by Ribbon in service A).

TBC
