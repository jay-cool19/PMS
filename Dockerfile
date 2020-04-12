FROM openjdk:8-jdk
MAINTAINER jaydev
WORKDIR /var/PMS
ADD target/PMS-1.0-SNAPSHOT.jar /var/PMS/PMS-1.0-SNAPSHOT.jar
ADD config.yaml /var/PMS/config.yaml
EXPOSE 9000
ENTRYPOINT ["java","-jar","PMS-1.0-SNAPSHOT.jar","server","config.yaml"]