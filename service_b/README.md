#Netflix OSS Example - Service B

##Introduction

This is a very simple microservice that simple echoes back the received message pre-appending a string obtained from the config repository.
 
##Configuration

###bootstrap.yml

This file contains the application name and the configuration service location.

##Quick Start

To compile:

```ShellSession
mvn clean package
```

To execute:

```ShellSession
java -jar target/service-b.jar
```

This will start the microservice B in an automatically assigned port 