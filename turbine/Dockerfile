#
# Dockerfile for Turbine
#

FROM java:8

MAINTAINER Oreste Luci

# Install maven
RUN apt-get update

VOLUME /tmp

WORKDIR /turbine

ADD target/turbine.jar turbine.jar

RUN bash -c 'touch /turbine.jar'

EXPOSE 8989
CMD ["/usr/lib/jvm/java-8-openjdk-amd64/bin/java", "-jar", "turbine.jar"]