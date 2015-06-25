#
# Dockerfile for Service C
#

FROM java:8

MAINTAINER Oreste Luci

# Install netcat
RUN apt-get update && apt-get install -y netcat

VOLUME /tmp

WORKDIR /service-c

ADD target/service-c.jar service-c.jar

RUN bash -c 'touch /service-c.jar'

ADD run.sh run.sh
RUN chmod 744 run.sh

CMD ["./run.sh","service-c.jar"]