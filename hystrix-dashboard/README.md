#Netflix OSS Example - Hystrix

Hystrix is a library that implemts the circuit breaker pattern. This means that the calls from one service to another wont be made
if the server service is not responding. The client service will call a fallback method to take care of the failed calls.
 
After a defined time period the circuit will be closed again and the client service calls will be directed to the server.

The Hystrix library is added to each micro-service that needs to use the circuit breaker pattern and also its have metrics gathered. 

More information about hystrix Clients can be found [here] (http://projects.spring.io/spring-cloud/spring-cloud.html#_circuit_breaker_hystrix_clients).

##Quick Start

To compile:

```ShellSession
mvn clean package
```

To execute:

```ShellSession
java -jar target/hystrix-dashboard.jar
```

The Dashboard is found at:

```ShellSession
http://localhost:7979/
```

See below on how to add a stream to the dashboard.


##Hystrix Endpoints

Hystrix provides various endpoints on top of the Actuator library to monitor the status of the calls.

####Health Indiator

```http://localhost:<port>/admin/health```

This endpoint will show the health of the service including the status hystrix:
 
```json
 {
   "description": "Spring Cloud Eureka Discovery Client",
   "status": "UP",
   "discovery": {
     "description": "Spring Cloud Eureka Discovery Client",
     "status": "UP",
     "discoveryClient": {
       "description": "Spring Cloud Eureka Discovery Client",
       "status": "UP",
       "services": [
         "servicec",
         "serviceb",
         "config-service",
         "servicea"
       ]
     }
   },
   "diskSpace": {
     "status": "UP",
     "free": 199103692800,
     "threshold": 10485760
   },
   "rabbit": {
     "status": "UP",
     "version": "3.5.2"
   },
   "configServer": {
     "status": "UP",
     "propertySources": []
   },
   "hystrix": {
     "status": "UP"
   }
 }
```

####Metrics Indicator

This indicator will display the metrics for the service. 

```
http://localhost:<port>/admin/metrics
```

The output is something like this:

```json
{
  "mem": 792064,
  "mem.free": 171802,
  "processors": 4,
  "instance.uptime": 2284876,
  "uptime": 2333072,
  "systemload.average": 3.64990234375,
  "heap.committed": 792064,
  "heap.init": 131072,
  "heap.used": 620261,
  "heap": 1864192,
  "threads.peak": 46,
  "threads.daemon": 28,
  "threads": 46,
  "classes": 9281,
  "classes.loaded": 9284,
  "classes.unloaded": 3,
  "gc.ps_scavenge.count": 16,
  "gc.ps_scavenge.time": 499,
  "gc.ps_marksweep.count": 2,
  "gc.ps_marksweep.time": 728,
  "httpsessions.max": -1,
  "httpsessions.active": 0,
  "counter.servo.discoveryclient-httpclient_createnew": 7,
  "counter.servo.discoveryclient-httpclient_delete": 1,
  "counter.servo.discoveryclient-httpclient_release": 533,
  "counter.servo.discoveryclient-httpclient_request": 533,
  "counter.servo.discoveryclient-httpclient_reuse": 526,
  "counter.servo.discoveryclient_failed": 0,
  "counter.servo.discoveryclient_reregister": 2,
  "counter.servo.discoveryclient_retry": 0,
  "counter.servo.eureka-connection-cleaner-failure": 0,
  "counter.servo.timedsupervisortask__heartbeat_rejectedexecutions": 0,
  "counter.servo.timedsupervisortask__heartbeat_throwables": 0,
  "counter.servo.timedsupervisortask__heartbeat_timeouts": 0,
  "counter.status.200.admin.health": 1,
  "counter.status.200.admin.hystrix.stream.star-star": 1,
  "counter.status.200.admin.info": 1,
  "counter.status.200.admin.metrics": 1,
  "counter.status.404.star-star": 4,
  "gauge.response.admin.health": 2904,
  "gauge.response.admin.hystrix.stream.star-star": 4041,
  "gauge.response.admin.info": 12,
  "gauge.response.admin.metrics": 18,
  "gauge.response.star-star": 55,
  "gauge.servo.connectioncount": 1,
  "gauge.servo.discoveryclient-httpclient_createconnectiontimer": 0,
  "gauge.servo.discoveryclient-httpclient_requestconnectiontimer": 0.246881,
  "gauge.servo.discoveryclient_cancel": 0,
  "gauge.servo.discoveryclient_fetchregistry": 14.243513,
  "gauge.servo.discoveryclient_getserviceurlsfromdns": 0,
  "gauge.servo.discoveryclient_refresh": 0,
  "gauge.servo.discoveryclient_refreshdelta": 11.816118,
  "gauge.servo.discoveryclient_register": 0,
  "gauge.servo.discoveryclient_renew": 21.102950999999997,
  "gauge.servo.eureka-connection-cleaner-time": 0.06503199999999999
}
```

####Hystrix Stream Endpoint

The hystrix library creates and endpoint which has the status of each of the calls. This stream is ment to be used with the Hystrix Dashboard.

```
http://localhost:<port>/hystrix.stream
```

##Hystrix Dashboard

The Hystrix Dashboard URL is:
  
```
http://localhost:7979
```  
  
You should see something like this:  

![Hystrix Home](https://github.com/Oreste-Luci/netflix-oss-example/blob/master/hystrix-dashboard/hystrix_home.png?raw=true)

Here you must enter the URL for the service Hystrix stream, ie:

```
http://localhost:<port>/hystrix.stream
```

> **Note:**
> If you are starting your turbine service with docker you must pass the URL of the container that is linked with an alias ```http://turbine-server:<port>/hystrix.stream```.
> Or instead search for the container ip's adress with ```docker ps -q | xargs docker inspect --format '{{ .Id }} - {{ .Name }} - {{ .NetworkSettings.IPAddress }}'```

You should see the graphs for all the Hystrix enabled methods in the service. For example:

![Hystrix Home](https://github.com/Oreste-Luci/netflix-oss-example/blob/master/hystrix-dashboard/hystrix_A.png?raw=true)

This willa llow you to monitor one service. In order to monitor several services at one in the Hystrix Dashboard we need to use an agregator like [Turbine](https://github.com/Oreste-Luci/netflix-oss-example/tree/master/turbine).


##Reference

Here is a video that show the Hystrix Dashboard:

[http://blog.fogcreek.com/hystrix-dashboard-tech-talk-with-demo/](http://blog.fogcreek.com/hystrix-dashboard-tech-talk-with-demo/)
