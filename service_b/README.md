#Netflix OSS Example - Service B

##Introduction

This is a very simple micro-service that simple forwards the calls to service C.

The purpose of this service is to server as a server to micro-service A. To test load balancing features you can instantiate this service multiple times, the auto port configuration will assign different ports.

##Quick Start
 
To compile:
 
```ShellSession
mvn clean package
```
 
To execute:
 
```ShellSession
java -jar target/service-b.jar
```
 
This will start the microservice B in an automatically assigned port and register it with eureka. To check if it has been successfully registered with eureka check the eureka status page:
 
```
http://localhost:8761/
```
 
To test the service you can do the following 
 
```ShellSession
curl http://localhost:<replace_with_service_port>/echo\?msg\=Hello | jq .
```
 
You should see the following output:
 
```json
{
  "message": "From local file Hello 8b4366d0-3d2a-4890-aaf5-9198ba643763"
}
```
 
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

You should see something like this.

```json
{
  "profiles": [
    "local"
  ],
  "configService:https://github.com/Oreste-Luci/netflix-oss-example-config-repo/serviceB-local.properties": {
    "default.message": "From local file"
  },
  "configService:https://github.com/Oreste-Luci/netflix-oss-example-config-repo/serviceB.properties": {
    "default.message": "From default file"
  },
  "servletContextInitParams": {},
  "systemProperties": {
    "java.runtime.name": "Java(TM) SE Runtime Environment",
    "java.protocol.handler.pkgs": "null|org.springframework.boot.loader",
    "sun.boot.library.path": "/Library/Java/JavaVirtualMachines/jdk1.8.0_45.jdk/Contents/Home/jre/lib",
    "java.vm.version": "25.45-b02",
    "user.country.format": "ES",
    "gopherProxySet": "false",
    "java.vm.vendor": "Oracle Corporation",
    "java.vendor.url": "http://java.oracle.com/",
    "path.separator": ":",
    "java.vm.name": "Java HotSpot(TM) 64-Bit Server VM",
    "file.encoding.pkg": "sun.io",
    "user.country": "US",
    "sun.java.launcher": "SUN_STANDARD",
    "sun.os.patch.level": "unknown",
    "PID": "42154",
    "java.vm.specification.name": "Java Virtual Machine Specification",
    "user.dir": "/netflix-oss-example/service_b",
    "java.runtime.version": "1.8.0_45-b14",
    "java.awt.graphicsenv": "sun.awt.CGraphicsEnvironment",
    "org.jboss.logging.provider": "slf4j",
    "java.endorsed.dirs": "/Library/Java/JavaVirtualMachines/jdk1.8.0_45.jdk/Contents/Home/jre/lib/endorsed",
    "os.arch": "x86_64",
    "java.io.tmpdir": "/var/folders/qg/l3ngq2592c128bf06t3r_1mh0000gn/T/",
    "line.separator": "\n",
    "java.vm.specification.vendor": "Oracle Corporation",
    "os.name": "Mac OS X",
    "sun.jnu.encoding": "UTF-8",
    "java.library.path": "....",
    "java.specification.name": "Java Platform API Specification",
    "java.class.version": "52.0",
    "archaius.deployment.applicationId": "serviceB",
    "sun.management.compiler": "HotSpot 64-Bit Tiered Compilers",
    "os.version": "10.10.3",
    "http.nonProxyHosts": "local|*.local|169.254/16|*.169.254/16",
    "user.home": "...",
    "catalina.useNaming": "false",
    "user.timezone": "Europe/Madrid",
    "java.awt.printerjob": "sun.lwawt.macosx.CPrinterJob",
    "file.encoding": "UTF-8",
    "java.specification.version": "1.8",
    "catalina.home": "/private/var/folders/qg/l3ngq2592c128bf06t3r_1mh0000gn/T/tomcat.6195244800423203811.0",
    "java.class.path": "target/service-b.jar",
    "user.name": "oreste",
    "java.vm.specification.version": "1.8",
    "sun.java.command": "target/service-b.jar",
    "java.home": "/Library/Java/JavaVirtualMachines/jdk1.8.0_45.jdk/Contents/Home/jre",
    "sun.arch.data.model": "64",
    "user.language": "en",
    "java.specification.vendor": "Oracle Corporation",
    "awt.toolkit": "sun.lwawt.macosx.LWCToolkit",
    "java.vm.info": "mixed mode",
    "java.version": "1.8.0_45",
    "java.ext.dirs": "....",
    "sun.boot.class.path": "...",
    "java.awt.headless": "true",
    "java.vendor": "Oracle Corporation",
    "catalina.base": "/private/var/folders/qg/l3ngq2592c128bf06t3r_1mh0000gn/T/tomcat.6195244800423203811.0",
    "file.separator": "/",
    "java.vendor.url.bug": "http://bugreport.sun.com/bugreport/",
    "sun.io.unicode.encoding": "UnicodeBig",
    "sun.cpu.endian": "little",
    "socksNonProxyHosts": "local|*.local|169.254/16|*.169.254/16",
    "ftp.nonProxyHosts": "local|*.local|169.254/16|*.169.254/16",
    "sun.cpu.isalist": ""
  },
  "systemEnvironment": {
    "PATH": "...",
    "JAVA_ARCH": "x86_64",
    "SPRING_PROFILES_ACTIVE": "local",
    "TERM": "xterm-256color",
    "ITERM_SESSION_ID": "w0t0p1",
    "LOGNAME": "oreste",
    "PWD": "...",
    "XPC_SERVICE_NAME": "0",
    "_": "/usr/bin/java",
    "SHELL": "/bin/zsh",
    "TERM_PROGRAM": "iTerm.app",
    "PAGER": "less",
    "LSCOLORS": "Gxfxcxdxbxegedabagacad",
    "JAVA_MAIN_CLASS_42154": "org.springframework.boot.loader.JarLauncher",
    "OLDPWD": "...",
    "USER": "oreste",
    "ZSH": ".oh-my-zsh",
    "ITERM_PROFILE": "Default",
    "TMPDIR": "/var/folders/qg/l3ngq2592c128bf06t3r_1mh0000gn/T/",
    "SSH_AUTH_SOCK": "/private/tmp/com.apple.launchd.p0naMlVXK1/Listeners",
    "XPC_FLAGS": "0x0",
    "M2_HOME": "/bin/apache-maven-3.3.3",
    "__CF_USER_TEXT_ENCODING": "0x1F5:0x0:0x0",
    "Apple_PubSub_Socket_Render": "/private/tmp/com.apple.launchd.FMhXrHqB14/Render",
    "com.apple.java.jvmTask": "CommandLine",
    "LESS": "-R",
    "LC_CTYPE": "UTF-8",
    "COLORFGBG": "7;0",
    "SHLVL": "1",
    "HOME": "..."
  },
  "applicationConfig: [classpath:/application.yml]": {
    "server.port": 0,
    "management.context-path": "/manage",
    "endpoints.restart.enabled": true,
    "endpoints.shutdown.enabled": true,
    "endpoints.health.sensitive": false,
    "eureka.client.registerWithEureka": true,
    "eureka.client.fetchRegistry": true,
    "eureka.client.serviceUrl.defaultZone": "http://127.0.0.1:8761/eureka/",
    "eureka.instance.leaseRenewalIntervalInSeconds": 5,
    "eureka.instance.leaseExpirationDurationInSeconds": 5,
    "eureka.instance.preferIpAddress": false,
    "eureka.instance.metadataMap.hostname": "${vcap.application.application_uris[0]}",
    "eureka.instance.metadataMap.instanceId": "${vcap.application.instance_id:${spring.application.name}:${spring.application.instance_id:${random.value}}}"
  },
  "applicationConfig: [classpath:/bootstrap.yml]": {
    "spring.application.name": "serviceB",
    "spring.profiles.active": "native",
    "spring.cloud.config.failFast": true,
    "spring.cloud.config.env": "default",
    "spring.cloud.config.label": "master",
    "spring.cloud.config.uri": "http://localhost:8888"
  },
  "defaultProperties": {
    "spring.application.name": "bootstrap"
  }
}
```

Another endpoint you can call to get app info is ```/info``` (in this example is admin since it was configured in the application.yml file). 
This will display the info that has been added in the properties files served by the configuration server. This information can also be added in the ```application.yml``` file as in the case of service A.


You can find more about actuator and all the endpoints it has [here] (http://docs.spring.io/spring-boot/docs/current-SNAPSHOT/reference/htmlsingle/#production-ready).


##Docker

Docker images can be created to test deploying the server into a different environment. The script to create the Docker image is contained in the Dockerfile.
 
###To create the image

The following commands creates the latest jar file and creates a Docker image called ```service-b```.

```
mvn clean package
docker build -t service-b .
```

###To run the container

The following command starts a new container named ```service-b``` from the ```service-b``` image. It maps port 9092 so that it can be reachable.

```
docker run -p 9092:9092 -d --name service-b -e "spring.profiles.active=docker" -e "server.port=9092" --add-host eureka-server-docker:<eureka server ip>  --add-host config-service-docker:<config service ip> service-b
```

To find out the ip of the eureka cand config service you can use the following command:
 
```
docker inspect <container name>
```
 


