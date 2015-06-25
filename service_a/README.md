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
curl http://localhost:9090/feign | jq .
```

You should see a response like this one:

```
{
 "message": "From local file 4a3d23f9-df76-44b0-b9db-ccc00ad50c0a"
}
```

####Load Balancing

Start more than one instance of service B and wait for it to be registered in Eureka (then after 30 seconds it will be obtained by Ribbon in service A).

You can call service A and you will see in the console output for services B the log from the controller as it is being served. 
You should see a Round Robin (default Ribbon balancing algorithm) call to services B.

```
curl http://localhost:9090/feign | jq .
```

If you kill (kill -9) one of services B you will see that Feign call skips (retries with the next one) if one of the server instances is down. 
If you do the same with the ```/restTemplate2``` call you will see an exception in the service A console output, since in this case the call is not retried to a live server.

##Docker

Docker images can be created to test deploying the server into a different environment. The script to create the Docker image is contained in the Dockerfile.
 
###To create the image

The following commands creates the latest jar file and creates a Docker image called ```service-a```.

```
mvn clean package
docker build -t service-a .
```

###To run the container

The following command starts a new container named ```service-a``` from the ```service-a``` image. It maps port 9091 so that it can be reachable.

```
docker run -p 9091:9091 -d --name service-a -e "spring.profiles.active=docker" -e "server.port=9091" --add-host eureka-server-docker:<eureka server ip>  --add-host config-service-docker:<config service ip> service-a
```

To find out the ip of the eureka cand config service you can use the following command:
 
```
docker inspect <container name>
```
 