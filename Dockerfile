FROM maven:3.6.3-jdk-17 AS build
LABEL MAINTAINER="CARLOS BEZERRA"

ADD . /opt/app

RUN set -ex \
		&& cd /opt/app \
		&& mvn install

FROM openjdk:17-alpine
ENV JAR_FILE="nf-0.0.1-SNAPSHOT.jar"
COPY target/${JAR_FILE} /${JAR_FILE}
CMD ["java", "-jar", "-Xms512M", "-Xmx4192M", "/produto-0.0.1-SNAPSHOT.jar"]