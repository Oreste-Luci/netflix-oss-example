#Netflix OSS Example - Config Service

##Introduction

This sevice will keep the configuration to be read by the micro-services. The objective is to have one centralized place to store the configuration.

##Quick Start

To compile:

```ShellSession
mvn clean package
```

To execute:

```ShellSession
java -jar target/config-service.jar
```

##Configuration

###bootstrap.yml

This is the first file read by the application when is run. This file contains the name of the application and where to find the configuration files.

The configuration files are stored in the following [git repository] (https://github.com/Oreste-Luci/netflix-oss-example-config-repo).

###application.yml

This file contains configurations for the port in which it should run, the eureka server to use, and the Actuator management path.

##Testing

Once the server is running it can be queried by:

```ShellSession
http://localhost:8888/{name}/{env}/{label}
```

Where:

* **name** is the application name
* **env** is the profile name (default by default)
* **label** is the branch name (master by default). This is optional and can be omitted.

For example:

```ShellSession
curl http://localhost:8888/serviceB/default/master | jq '.'
```

It should return something like this:

```json
{
  "name": "default",
  "label": "",
  "propertySources": [
    {
      "name": "https://github.com/Oreste-Luci/netflix-oss-example-config-repo/serviceB.properties",
      "source": {
        "default.message": "From default file"
      }
    }
  ]
}
```

If we know query for local we should get something like this:

```ShellSession
curl http://localhost:8888/serviceB/local/master | jq '.'
```

Result:

```json

  "name": "local",
  "label": "",
  "propertySources": [
    {
      "name": "https://github.com/Oreste-Luci/netflix-oss-example-config-repo/serviceB-local.properties",
      "source": {
        "default.message": "From local file"
      }
    },
    {
      "name": "https://github.com/Oreste-Luci/netflix-oss-example-config-repo/serviceB.properties",
      "source": {
        "default.message": "From default file"
      }
    }
  ]
}
```

As you can see it returns the default configuration overridden by the local configuration.

Now you have the config server running and reading the configuration files from a git repository. When the files are updated in the repository the config service will return the new versions.

More information can be found [here] (http://cloud.spring.io/spring-cloud-config/spring-cloud-config.html).

##Refreshing Changes

There is an endpoint in the microservices to refresh the changes in the configuration file. A POST request must be issued ```/refresh``` endpoint. 

```ShellSession
curl -X POST http://localhost:<port>/refresh
```

To refresh all services at once ```spring cloud bus``` adds a ```/bus/refresh``` endpoint to the microservices. If this endpoint is called it will send refresh message to all the
microservices via RabbitMQ. For this to work RabbitMQ must be running. For example:  

```ShellSession
curl -X POST http://localhost:<port>/bus/refresh
```

More info [here](http://cloud.spring.io/spring-cloud-config/spring-cloud-config.html)

##Docker

Docker images can be created to test deploying the server into a different environment. The script to create the Docker image is contained in the Dockerfile.
 
###To create the image

The following commands creates the latest jar file and creates a Docker image called ```config-service```.

```
mvn clean package
docker build -t config-service .
```

###To run the container

The following command starts a new container named ```config-service``` from the ```config-service``` image. It maps port 8888 so that it can be reachable.

```
docker run -p 8888:8888 -d --name config-service config-service
```