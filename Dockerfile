# syntax=docker/dockerfile:1

# Create a stage for resolving and downloading dependencies.
FROM eclipse-temurin:21-jdk-jammy AS deps

WORKDIR /build

# Install git
RUN apt-get update && apt-get install -y git && rm -rf /var/lib/apt/lists/*

# Copy the mvnw wrapper with executable permissions.
COPY --chmod=0755 mvnw mvnw
COPY .mvn/ .mvn/
COPY pom.xml .

# Debug: List files
RUN ls -la /build

# Download dependencies as a separate step to take advantage of Docker's caching.
RUN --mount=type=cache,target=/root/.m2 ./mvnw dependency:go-offline -DskipTests
