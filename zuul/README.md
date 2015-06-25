#Netflix OSS Example - Zuul

Zuul is a gatekeeper that uses Eureka to discover the services. It uses Ribbon to balance service calls.

##Quick Start

To compile:

```ShellSession
mvn clean package
```

To execute:

```ShellSession
java -jar target/zuul.jar
```

To test Service A:

```ShellSession
curl http://localhost:8765/servicea/feign | jq .
```

You should see something like this:

```json
{
  "message": "From local file f06f205d-de9d-40f7-adbe-76fb918b4e43 8f020ee0-851a-4ec4-be0a-afd2f611d923"
}
```

This Zuul server is configured to only forward calls to Service A, for all other services a 404 is returned. Example:

```ShellSession
curl http://localhost:8765/serviceb/test | jq .
```

The response should be something like this:

```json
{
  "timestamp": 1432135211314,
  "status": 404,
  "error": "Not Found",
  "message": "No message available",
  "path": "/serviceb/test"
}
```

##Hystrix Console
    
The ```org.springframework.cloud:spring-cloud-netflix-hystrix-amqp``` has been added to the pom.xml, this means that Hystrix stream will be added to RabbitMQ so that
Turbine can aggregate it to the stream to be used in Hystrix Dashboard.

More information about Zuul can be found [here](http://projects.spring.io/spring-cloud/spring-cloud.html#_router_and_filter_zuul).

