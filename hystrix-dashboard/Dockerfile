#
# Dockerfile for Eureka Server
#

FROM java:8

MAINTAINER Oreste Luci

# Install netcat
RUN apt-get update && apt-get install -y netcat

VOLUME /tmp

WORKDIR /hystrix-dashboard

ADD target/hystrix-dashboard.jar hystrix-dashboard.jar

RUN bash -c 'touch /hystrix-dashboard.jar'

EXPOSE 7979
CMD ["/usr/lib/jvm/java-8-openjdk-amd64/bin/java", "-jar", "hystrix-dashboard.jar"]
