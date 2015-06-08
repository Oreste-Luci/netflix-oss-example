#
# Dockerfile for Eureka Server
#

FROM java:8

MAINTAINER Oreste Luci

# Install maven
RUN apt-get update

VOLUME /tmp

WORKDIR /eureka-server

ADD target/eureka-service.jar eureka-service.jar

RUN bash -c 'touch /eureka-service.jar'

EXPOSE 8761
CMD ["/usr/lib/jvm/java-8-openjdk-amd64/bin/java", "-jar", "eureka-service.jar"]
