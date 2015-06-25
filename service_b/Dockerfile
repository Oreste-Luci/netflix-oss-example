#
# Dockerfile for Service B
#

FROM java:8

MAINTAINER Oreste Luci

# Install netcat
RUN apt-get update && apt-get install -y netcat

VOLUME /tmp

WORKDIR /service-b

ADD target/service-b.jar service-b.jar

RUN bash -c 'touch /service-b.jar'

ADD run.sh run.sh
RUN chmod 744 run.sh

CMD ["./run.sh","service-b.jar"]