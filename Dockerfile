# Start with a base image containing Maven
#FROM maven:3.8.4-openjdk-11-slim AS build
FROM maven:latest AS build

# Set the working directory in the Maven container
WORKDIR /usr/src/app

# Copy the pom.xml file
COPY pom.xml .

# Download all required dependencies into one layer
RUN mvn -B dependency:resolve dependency:resolve-plugins

# Copy your other files
COPY src ./src

# Build the application
RUN mvn package

# Start with Tomcat base image
FROM tomcat:9.0.88-jdk21

# Copy the WAR file from the Maven build stage into the Tomcat container
COPY --from=build /usr/src/app/target/*.war /usr/local/tomcat/webapps/ROOT.war

# Expose port 8080 for the application
EXPOSE 8080

# Start Tomcat server
CMD ["catalina.sh", "run"]
