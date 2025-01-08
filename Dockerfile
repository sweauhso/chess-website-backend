# Use an official Maven image with Java
FROM maven:3.8.6-openjdk-17 AS build

# Set working directory
WORKDIR /app

# Copy pom.xml and dependencies first (for caching)
COPY pom.xml .
RUN mvn dependency:go-offline

# Copy project files
COPY . .

# Build the application
RUN mvn clean package

# Use a lightweight Java runtime for production
FROM openjdk:17-jdk-slim

# Set working directory
WORKDIR /app

# Copy the built JAR from the first stage
COPY --from=build /app/target/*.jar app.jar

# Expose the application's port (Spring Boot default is 8080)
EXPOSE 8080

# Run the application
CMD ["java", "-jar", "app.jar"]
