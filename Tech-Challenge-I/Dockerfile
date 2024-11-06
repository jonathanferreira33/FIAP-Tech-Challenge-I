FROM maven:3.8.1-openjdk-17 AS builder

WORKDIR /app

COPY target/*.jar app.jar
EXPOSE 8080

ENTRYPOINT ["java","-jar","app.jar"]

