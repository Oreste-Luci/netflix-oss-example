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

