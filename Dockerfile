# Dockerfile - builds an image that runs your Spring Boot JAR
FROM eclipse-temurin:17-jdk-jammy

WORKDIR /app

# copy the fat jar produced by Maven to the image
ARG JAR_FILE=TODO/target/TODO-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} app.jar

EXPOSE 8080

ENTRYPOINT ["java","-jar","/app/app.jar"]
