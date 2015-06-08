#
# Dockerfile for Service B
#

FROM java:8

MAINTAINER Oreste Luci

# Install maven
RUN apt-get update

VOLUME /tmp

WORKDIR /service-a

ADD target/service-a.jar service-a.jar

RUN bash -c 'touch /service-a.jar'

EXPOSE 9091
CMD ["/usr/lib/jvm/java-8-openjdk-amd64/bin/java", "-jar", "service-a.jar", "--server.port=9091"]