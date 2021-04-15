FROM adoptopenjdk/openjdk11:jre-11.0.10_9-alpine
ADD target/scope-gasconnection-service-0.0.1-SNAPSHOT.jar .
EXPOSE 8095
CMD java -jar scope-gasconnection-service-0.0.1-SNAPSHOT.jar