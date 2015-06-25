#
# Dockerfile for Service C
#

FROM java:8

MAINTAINER Oreste Luci

# Install netcat
RUN apt-get update && apt-get install -y netcat

VOLUME /tmp

WORKDIR /zuul

ADD target/zuul.jar zuul.jar

RUN bash -c 'touch /zuul.jar'

CMD ["/usr/lib/jvm/java-8-openjdk-amd64/bin/java", "-jar", "zuul.jar"]