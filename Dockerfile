# Use an official Maven image with JDK 21
FROM maven:3.9.7-eclipse-temurin-21 AS build

# Set the working directory
WORKDIR /app

# Copy the Maven configuration files and the project source files
COPY .mvn/ .mvn
COPY pom.xml .
COPY src/ src/

# Build the application
RUN mvn clean package -DskipTests

# Use an official Eclipse Temurin image with JDK 21 as the base image for the application
FROM eclipse-temurin:21-jdk

# Set the working directory
WORKDIR /app

# Copy the built application from the build stage
COPY --from=build /app/target/*.jar app.jar

# Expose the port the application runs on
EXPOSE 8081

# Command to run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
