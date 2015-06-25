#Netflix OSS Example - Docker Compose

##Introduction

Docker-compose configure to set up all the needed containers and their relations to run easily this example. Also it provides a simple client that randomly calls the different service endpoints in order to generate traffic for display the status of each endpoint in the histryx dashboard, spring cloud dashboard 

##Quick Start

Run it:

```ShellSession
docker-compose up -d
```
Once everything is everything is booted up, you can go to the [Spring cloud configuration](https://github.com/Oreste-Luci/netflix-oss-example/tree/master/spring-cloud-dashboard) to se the various dashboards and usage of the apis.

## Installation
To run it, docker compose must be installed. Just go to the [installation instructions](https://docs.docker.com/compose/install/).
Or just type:
```ShellSession
curl -L https://github.com/docker/compose/releases/download/1.3.1/docker-compose-`uname -s`-`uname -m` > /usr/local/bin/docker-compose
chmod +x /usr/local/bin/docker-compose
```

##Configuration
The configuration is in the ```docker-compose.yml```. Note that in the services haven't any exposed ports to prove the functionality of the service auto-registering in eureka and the ability of ribbon to access them.  

## Usage

### Start the containers
```ShellSession
docker-compose up -d
```

### Scale the services instances
If you want to scale the number of instances of a specific service use the argument ```scale```. For exmaple if we want to scale the serviceA with 3 instances and the serviceC with 5 instances:
```ShellSession
docker-compose scale servicea=3 servicec=5
```
### Troubleshooting
If not all services have started correctly, you can check it with ```docker-compose ps```, just execute:
```ShellSession
docker-compose up - --no-recreate
```

