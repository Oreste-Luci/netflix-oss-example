#
# Dockerfile for Service B
#

FROM java:8

MAINTAINER Oreste Luci

# Install maven
RUN apt-get update

VOLUME /tmp

WORKDIR /service-b

ADD target/service-b.jar service-b.jar

RUN bash -c 'touch /service-b.jar'

EXPOSE 9092
CMD ["/usr/lib/jvm/java-8-openjdk-amd64/bin/java", "-jar", "service-b.jar", "--server.port=9092"]