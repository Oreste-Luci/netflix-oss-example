#
# Dockerfile for Turbine
#

FROM java:8

MAINTAINER Oreste Luci

# Install netcat
RUN apt-get update && apt-get install -y netcat

VOLUME /tmp

WORKDIR /spring-boot-admin

ADD target/spring-boot-admin.jar spring-boot-admin.jar

RUN bash -c 'touch /spring-boot-admin.jar'

EXPOSE 8085
CMD ["/usr/lib/jvm/java-8-openjdk-amd64/bin/java", "-jar", "spring-boot-admin.jar"]