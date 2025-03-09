# Use an official OpenJDK 17 base image from Docker Hub
FROM openjdk:17-jdk-alpine

# Set the working directory inside the container
WORKDIR /app

# Copy the JAR file (created by 'mvn package' or 'mvn install') into the container
# Make sure to replace 'management-software-1.0-SNAPSHOT.jar' with your actual JAR name
COPY target/management-software-1.0-SNAPSHOT.jar app.jar

# Expose the port your Spring Boot application runs on (default is 8080)
EXPOSE 8080

# Define the entry point command to run the application
# 'java -jar app.jar' will start the Spring Boot application
ENTRYPOINT ["java", "-jar", "app.jar"]