FROM openjdk:17-jdk-alpine
COPY target/movie-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["gitjava","-jar","/app.jar"]