# Build stage (compiles the JAR)
FROM eclipse-temurin:21 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
COPY target/huddle-1.2.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
