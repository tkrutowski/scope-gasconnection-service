FROM adoptopenjdk/openjdk11:jdk-11.0.2.7-alpine-slim
COPY java.security /opt/java/openjdk/conf/security
COPY target/scope-gasconnection-service-0.0.1-SNAPSHOT.jar .
EXPOSE 8094
CMD java -jar scope-gasconnection-service-0.0.1-SNAPSHOT.jar