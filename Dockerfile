# Build stage (compiles the JAR)
FROM eclipse-temurin:21 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
COPY target/huddle-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
