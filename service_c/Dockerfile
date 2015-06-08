#
# Dockerfile for Service C
#

FROM java:8

MAINTAINER Oreste Luci

# Install maven
RUN apt-get update

VOLUME /tmp

WORKDIR /service-c

ADD target/service-c.jar service-c.jar

RUN bash -c 'touch /service-c.jar'

EXPOSE 9093
CMD ["/usr/lib/jvm/java-8-openjdk-amd64/bin/java", "-jar", "service-c.jar", "--server.port=9093"]