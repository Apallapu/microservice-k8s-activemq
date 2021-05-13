FROM openjdk:8-jre-alpine
COPY target/newbus-service-1.0-SNAPSHOT.jar .
CMD /usr/bin/java -Xmx400m -Xms400m -jar newbus-service-1.0-SNAPSHOT.jar
EXPOSE 8080