#
# Dockerfile for Config Service
#

FROM java:8

MAINTAINER Oreste Luci

# Install netcat
RUN apt-get update && apt-get install -y netcat

VOLUME /tmp

WORKDIR /config-service

ADD target/config-service.jar config-service.jar

RUN bash -c 'touch /config-service.jar'

EXPOSE 8888
CMD ["/usr/lib/jvm/java-8-openjdk-amd64/bin/java", "-jar", "config-service.jar"]
