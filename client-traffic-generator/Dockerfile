#
# Dockerfile for Service C
#

FROM java:8

MAINTAINER Oreste Luci

# Install netcat
RUN apt-get update && apt-get install -y netcat

VOLUME /tmp

WORKDIR /client-traffic-generator

ADD target/client-traffic-generator.jar client-traffic-generator.jar

RUN bash -c 'touch /client-traffic-generator.jar'

ADD run.sh run.sh
RUN chmod 744 run.sh

CMD ["./run.sh","client-traffic-generator.jar"]