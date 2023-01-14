FROM amazoncorretto: 11-alphine-jdk
MAINTAINER AGN
COPY target/mgb-0.0.1-SNAPSHOT.jar  agn-app.jar
ENTRYPOINT["java","-jar", "/agn-app.jar"]